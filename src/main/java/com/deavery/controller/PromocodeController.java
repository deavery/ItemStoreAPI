package com.deavery.controller;

import com.deavery.service.PromocodeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shop/promocode")
@AllArgsConstructor
@Slf4j
public class PromocodeController {

    private final PromocodeService promocodeService;

    @GetMapping
    public ResponseEntity<?> checkPromocode (
            @RequestParam int merchandise,
            @RequestParam String promocode
    ) {
        return ResponseEntity.ok(promocodeService.checkPromocode(merchandise, promocode));
    }
}
