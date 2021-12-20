package com.deavery.repository;

import com.deavery.model.dto.CategoryDto;

import java.util.List;

public interface CategoryRepository {
    List<CategoryDto> getAll();
}
