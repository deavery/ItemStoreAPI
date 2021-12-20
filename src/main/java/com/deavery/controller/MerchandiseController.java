package com.deavery.controller;

import com.deavery.service.MerchandiseService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shop/merchandise")
@AllArgsConstructor
@Slf4j
public class MerchandiseController {

    private final MerchandiseService merchandiseService;

    @GetMapping("/list")
    public ResponseEntity<?> getList (
            @RequestParam int category
    ) {
        return ResponseEntity.ok(merchandiseService.getList(category));
    }
}
