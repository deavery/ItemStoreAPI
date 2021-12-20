package com.deavery.service;

import com.deavery.model.dto.PayDto;
import com.deavery.model.dto.PayLinkDto;

public interface PaymentService {
    PayLinkDto pay(PayDto pay);
}
