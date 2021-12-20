package com.deavery.exception.runtime;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class PaymentIllegalData extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private String errorCode;
    private String errorMessage;
}
