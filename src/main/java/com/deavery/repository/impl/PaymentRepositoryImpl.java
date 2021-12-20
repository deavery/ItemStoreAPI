package com.deavery.repository.impl;

import com.deavery.model.Merchandise;
import com.deavery.model.Payment;
import com.deavery.model.dto.PayDto;
import com.deavery.model.dto.PayLinkDto;
import com.deavery.repository.PaymentRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
@AllArgsConstructor
@Slf4j
public class PaymentRepositoryImpl implements PaymentRepository {

    private final JdbcTemplate jdbcTemplate;

    private static Payment mapMerchandise(ResultSet rs, int rowNum) throws SQLException {
        return new Payment(
                rs.getInt("id"),
                rs.getInt("merchandise"),
                rs.getString("nickname"),
                rs.getLong("date"),
                rs.getDouble("price"),
                rs.getInt("count"),
                rs.getDouble("payment_price"),
                rs.getInt("promocode"),
                rs.getBoolean("status")
        );
    }


    @Override
    public PayLinkDto pay(Payment payment) {
        Payment pay = jdbcTemplate.queryForObject(
          "INSERT INTO payment (merchandise, nickname, date, price, count, payment_price, promocode, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?) RETURNING id, merchandise, nickname, date, price, count, payment_price, promocode, status",
                PaymentRepositoryImpl::mapMerchandise,
                payment.getMerchandise(),
                payment.getNickname(),
                payment.getDate(),
                payment.getPrice(),
                payment.getCount(),
                payment.getPaymentPrice(),
                payment.getPromocode() > 0 ? payment.getPromocode() : null,
                payment.isStatus()
        );
        return new PayLinkDto(
          "https://pay.io/paymentLink" + pay.getPaymentPrice() + pay.getNickname() + pay.getId() + pay.getPromocode() + pay.getDate() + pay.getMerchandise()
        );
    }
}
