package com.deavery.service;

import com.deavery.model.Promocode;

public interface PromocodeService {
    int checkPromocode(int merchandise, String promocode);

    Promocode getPromocode(String promocode);
}
