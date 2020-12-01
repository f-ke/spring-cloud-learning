package com.keke.microservices.netfilixeurekanamingserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class NetfilixEurekaNamingServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(NetfilixEurekaNamingServerApplication.class, args);
	}

}
