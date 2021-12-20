package com.deavery.query.postgresql;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Getter
@Component
@PropertySource("classpath:query.properties")
public class MerchandisePgSql {

    @Value("${merchandise.get.list}")
    private String getList;

    @Value("${merchandise.get.by.id}")
    private String getById;
}
