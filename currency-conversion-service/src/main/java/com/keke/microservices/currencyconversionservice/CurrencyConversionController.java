package com.keke.microservices.currencyconversionservice;

import com.keke.microservices.currencyconversionservice.bean.CorrencyConversionBean;
import java.math.BigDecimal;
import java.util.HashMap;
import org.apache.logging.log4j.spi.LoggerContextFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CurrencyConversionController {
  @Autowired
 private CurrencyExchangeServiceProxy proxy;
  private Logger logger = LoggerFactory.getLogger(this.getClass());
  @GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
  public CorrencyConversionBean retriveCorrencyBean(@PathVariable String from,
      @PathVariable String to, @PathVariable BigDecimal quantity
  ){
    HashMap<String, String> uriMap = new HashMap<>();
    uriMap.put("from", from);
    uriMap.put("to",to);
    ResponseEntity<CorrencyConversionBean> responseEntity = new RestTemplate()
        .getForEntity("http://localhost:8001/currency-exchange/from/{from}/to/{to}",
            CorrencyConversionBean.class, uriMap);
      CorrencyConversionBean response = responseEntity.getBody();
    return new CorrencyConversionBean(response.getId(), from, to, quantity,quantity.multiply(response.getConversionMultiple()),
        response.getConversionMultiple(),response.getPort());
  }
  //feigh client
  @GetMapping("/currency-converter-feigh/from/{from}/to/{to}/quantity/{quantity}")
  public CorrencyConversionBean retriveCorrencyBeanFeigh(@PathVariable String from,
      @PathVariable String to, @PathVariable BigDecimal quantity
  ){
      CorrencyConversionBean response = proxy.retriveExchangeValue(from, to);
      logger.info("{}",response);
    return new CorrencyConversionBean(response.getId(), from, to, quantity,quantity.multiply(response.getConversionMultiple()),
        response.getConversionMultiple(),response.getPort());
  }

}
