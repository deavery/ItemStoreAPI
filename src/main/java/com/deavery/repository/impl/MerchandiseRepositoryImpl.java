package com.deavery.repository.impl;

import com.deavery.model.Merchandise;
import com.deavery.model.dto.MerchandiseDto;
import com.deavery.query.postgresql.MerchandisePgSql;
import com.deavery.repository.MerchandiseRepository;
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
public class MerchandiseRepositoryImpl implements MerchandiseRepository {

    private final JdbcTemplate jdbcTemplate;
    private final MerchandisePgSql q;

    private static MerchandiseDto mapMerchandiseDto(ResultSet rs, int rowNum) throws SQLException {
        return new MerchandiseDto(
                rs.getInt("id"),
                rs.getString("title"),
                rs.getString("description"),
                rs.getDouble("price"),
                rs.getBoolean("surcharge"),
                rs.getBoolean("promocode"),
                rs.getInt("discount"),
                rs.getString("image"),
                rs.getInt("quantitative")
        );
    }

    private static Merchandise mapMerchandise(ResultSet rs, int rowNum) throws SQLException {
        return new Merchandise(
                rs.getInt("id"),
                rs.getInt("info"),
                rs.getDouble("price"),
                rs.getInt("category"),
                rs.getBoolean("surcharge"),
                rs.getBoolean("promocode"),
                rs.getInt("discount"),
                rs.getString("image"),
                rs.getString("item"),
                rs.getInt("quantitative"),
                rs.getBoolean("active")
        );
    }

    @Override
    public List<MerchandiseDto> getList(int category) {
        return jdbcTemplate.query(q.getGetList(), MerchandiseRepositoryImpl::mapMerchandiseDto, category);
    }

    @Override
    public Merchandise getById(int id) {
        return  jdbcTemplate.queryForObject(q.getGetById(),  MerchandiseRepositoryImpl::mapMerchandise, id);
    }

}
