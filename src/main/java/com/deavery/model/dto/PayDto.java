package com.deavery.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PayDto {
    String nickname;
    int merchandise;
    int count;
    String promocode;
}
