package com.deavery.repository.impl;

import com.deavery.model.dto.CategoryDto;
import com.deavery.query.postgresql.CategoryPgSql;
import com.deavery.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
@AllArgsConstructor
@Slf4j
public class CategoryRepositoryImpl implements CategoryRepository {

    private final JdbcTemplate jdbcTemplate;
    private final CategoryPgSql q;

    private static CategoryDto mapCategoryDto(ResultSet rs, int rowNum) throws SQLException {
        return new CategoryDto(
                rs.getInt("id"),
                rs.getString("title"),
                rs.getString("description"),
                rs.getBoolean("surcharge")
        );
    }

    @Override
    public List<CategoryDto> getAll() {
        return jdbcTemplate.query(q.getGetAll(), CategoryRepositoryImpl::mapCategoryDto);
    }
}
