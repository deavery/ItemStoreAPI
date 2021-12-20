package com.deavery.service.impl;

import com.deavery.exception.runtime.MerchandiseDoesNotExists;
import com.deavery.exception.runtime.PaymentIllegalData;
import com.deavery.model.Merchandise;
import com.deavery.model.Payment;
import com.deavery.model.dto.PayDto;
import com.deavery.model.dto.PayLinkDto;
import com.deavery.repository.PaymentRepository;
import com.deavery.service.MerchandiseService;
import com.deavery.service.PaymentService;
import com.deavery.service.PromocodeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@AllArgsConstructor
@Slf4j
@Transactional
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final MerchandiseService merchandiseService;
    private final PromocodeService promocodeService;

    @Override
    public PayLinkDto pay(PayDto pay) {
        Merchandise merchandise;
        try {merchandise = merchandiseService.getById(pay.getMerchandise());}
        catch (EmptyResultDataAccessException ex) {throw new MerchandiseDoesNotExists();}

        if (pay.getCount() > merchandise.getQuantitative())
            throw new PaymentIllegalData();
        int discount = promocodeService.checkPromocode(merchandise.getId(), pay.getPromocode());
        int promocode = 0;
        if (discount > 0)
            promocode = promocodeService.getPromocode(pay.getPromocode()).getId();

        double price = pay.getCount()*merchandise.getPrice();
        double paymentPrice = Math.ceil((price/100)*(100-discount));

        Payment payment = new Payment(
          0,
          merchandise.getId(),
          pay.getNickname(),
          new Date().getTime(),
          merchandise.getPrice(),
          pay.getCount(),
          paymentPrice,
          promocode,
          false
        );


        return paymentRepository.pay(payment);
    }
}
