package com.keke.microservices.currencyexchangeservice;

import com.keke.microservices.currencyexchangeservice.bean.ExchangeValue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long>
{
        //creating query method
        ExchangeValue findByFromAndTo(String from, String to);
}
