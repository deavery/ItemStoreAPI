package com.deavery.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Promocode {
    int id;
    String promocode;
    int category;
    int discount;
    long fromDate;
    long toDate;
    boolean active;
}
