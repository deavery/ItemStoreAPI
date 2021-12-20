package com.deavery.exception;

import com.deavery.exception.runtime.MerchandiseDoesNotExists;
import com.deavery.exception.runtime.PaymentIllegalData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(MerchandiseDoesNotExists.class)
    public ResponseEntity<String> handleMerchandiseDoesNotExists(MerchandiseDoesNotExists merchandiseDoesNotExists){
        return new ResponseEntity<String>("This merchandise does not exists!", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PaymentIllegalData.class)
    public ResponseEntity<String> handlePaymentIllegalData(PaymentIllegalData merchandiseDoesNotExists){
        return new ResponseEntity<String>("The quantity of merchandise exceeds the limit!", HttpStatus.BAD_REQUEST);
    }

}
