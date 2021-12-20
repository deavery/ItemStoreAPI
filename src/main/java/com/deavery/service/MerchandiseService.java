package com.deavery.service;

import com.deavery.model.Merchandise;
import com.deavery.model.dto.MerchandiseDto;

import java.util.List;

public interface MerchandiseService {
    List<MerchandiseDto> getList(int category);

    Merchandise getById(int id);
}
