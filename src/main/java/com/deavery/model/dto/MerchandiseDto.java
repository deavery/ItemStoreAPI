package com.deavery.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MerchandiseDto {
    int id;
    String title;
    String description;
    double price;
    boolean surcharge;
    boolean promocode;
    int discount;
    String image;
    int quantitative;
}
