package com.deavery.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    int id;
    int merchandise;
    String nickname;
    long date;
    double price;
    int count;
    double paymentPrice;
    int promocode;
    boolean status;
}
