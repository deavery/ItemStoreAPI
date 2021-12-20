package com.deavery.service.impl;

import com.deavery.exception.runtime.MerchandiseDoesNotExists;
import com.deavery.model.Merchandise;
import com.deavery.model.Promocode;
import com.deavery.repository.PromocodeRepository;
import com.deavery.service.MerchandiseService;
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
public class PromocodeServiceImpl implements PromocodeService {

    private final MerchandiseService merchandiseService;
    private final PromocodeRepository promocodeRepository;

    @Override
    public int checkPromocode(int merchandise, String promocode) {
        Merchandise mQuery;
        try {
            mQuery = merchandiseService.getById(merchandise);
        } catch (EmptyResultDataAccessException ex) {
            throw new MerchandiseDoesNotExists();
        }
        if (!mQuery.isPromocode()) return 0;
        Promocode pQuery;
        try {
            pQuery = promocodeRepository.getPromocode(promocode);
        } catch (EmptyResultDataAccessException ex) {
            return 0;
        }
        Date date = new Date();
        long millis = date.getTime();
        if (millis < pQuery.getFromDate() || millis > pQuery.getToDate()) return 0;
        int pCategory = pQuery.getCategory();
        if (pCategory == mQuery.getCategory() || pCategory == 0) {
            return pQuery.getDiscount();
        }
        return 0;
    }

    @Override
    public Promocode getPromocode (String promocode) {
        return promocodeRepository.getPromocode(promocode);
    }
}
