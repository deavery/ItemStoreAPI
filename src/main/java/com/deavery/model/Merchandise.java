package com.deavery.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Merchandise {
    int id;
    int info;
    double price;
    int category;
    boolean surcharge;
    boolean promocode;
    int discount;
    String image;
    String item;
    int quantitative;
    boolean active;
}
