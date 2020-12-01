package com.keke.microservices.currencyconversionservice;

import com.keke.microservices.currencyconversionservice.bean.CorrencyConversionBean;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name="currency-exchange-service", url = "localhost:8001")
@RibbonClient(name= "currency-exchange-service")
//@FeignClient(name = "currency-exchange-service")
@FeignClient(name = "neflix-zuui-api-gateway-server")
public interface CurrencyExchangeServiceProxy {
  //@GetMapping("/currency-exchange/from/{from}/to/{to}")
  @GetMapping("/currency-exchange-service/currency-exchange/from/{from}/to/{to}")
  public CorrencyConversionBean retriveExchangeValue(@PathVariable String from, @PathVariable String to);

}
