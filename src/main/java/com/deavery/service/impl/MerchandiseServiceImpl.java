package com.deavery.service.impl;

import com.deavery.model.Merchandise;
import com.deavery.model.dto.MerchandiseDto;
import com.deavery.repository.MerchandiseRepository;
import com.deavery.service.MerchandiseService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
@Transactional
public class MerchandiseServiceImpl implements MerchandiseService {

    private final MerchandiseRepository merchandiseRepository;

    @Override
    public List<MerchandiseDto> getList(int category) {
        return merchandiseRepository.getList(category);
    }

    @Override
    public Merchandise getById(int id) {
        return merchandiseRepository.getById(id);
    }
}
