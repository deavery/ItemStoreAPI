package com.deavery.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    int id;
    int description;
    boolean surcharge;
    boolean active;
}
