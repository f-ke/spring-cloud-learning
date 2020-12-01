package com.keke.microservices.limitsservice;

import com.keke.microservices.limitsservice.bean.LimitServiceConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsSeviceConfigrueController {
  @Autowired
 private Configuration configuration;
  @GetMapping("/limits")
  public LimitServiceConfiguration retriveConfigure(){
    return new LimitServiceConfiguration(configuration.getMaximum(),configuration.getMinimum());
  }


}
