package com.deavery.repository.impl;

import com.deavery.model.Promocode;
import com.deavery.query.postgresql.PromocodePgSql;
import com.deavery.repository.PromocodeRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
@AllArgsConstructor
@Slf4j
public class PromocodeRepositoryImpl implements PromocodeRepository {

    private final JdbcTemplate jdbcTemplate;
    private final PromocodePgSql q;

    private static Promocode mapPromocode(ResultSet rs, int rowNum) throws SQLException {
        return new Promocode(
                rs.getInt("id"),
                rs.getString("promocode"),
                rs.getInt("category"),
                rs.getInt("discount"),
                rs.getLong("from_date"),
                rs.getLong("to_date"),
                rs.getBoolean("active")
        );
    }

    @Override
    public Promocode getPromocode(String promocode) {
        return jdbcTemplate.queryForObject(q.getGetByPromocode(), PromocodeRepositoryImpl::mapPromocode, promocode);
    }
}
