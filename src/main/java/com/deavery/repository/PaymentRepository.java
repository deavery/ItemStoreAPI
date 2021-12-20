package com.deavery.repository;

import com.deavery.model.Payment;
import com.deavery.model.dto.PayDto;
import com.deavery.model.dto.PayLinkDto;

public interface PaymentRepository {
    PayLinkDto pay (Payment payment);
}
