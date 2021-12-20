package com.deavery.repository;

import com.deavery.model.Merchandise;
import com.deavery.model.dto.MerchandiseDto;

import java.util.List;

public interface MerchandiseRepository {
    List<MerchandiseDto> getList(int category);

    Merchandise getById(int id);
}
