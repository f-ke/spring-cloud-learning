# Master spring-cloud 

![image-20201129120836971](C:\Users\fanke\AppData\Roaming\Typora\typora-user-images\image-20201129120836971.png)

Step 1: build easy limite-service



Step 2 : build spring-cloud-server at local 8888, modifiy the preperty file of limit-service



step 3 : build local empty git repositry 

Eclipse: left: build path->link-source /Idea: add root folder to spirng-cloud-server



step 4 : add properties file of limit-service in git repostry

note:change the property file of limit-service to : bootstrap.property

​          define the server url in this file

step 5 : build currency-exchange-service and currency-conversion-service

step 6: call exchage service at currency-conversion service by Feigh:

note: we can simply call it by RestTemplate in hard code, 

```
@RestController
public class CurrencyConversionController {
  @Autowired
 private CurrencyExchangeServiceProxy proxy;
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
  
```

compare to Feigh:

```
@GetMapping("/currency-converter-feigh/from/{from}/to/{to}/quantity/{quantity}")
  public CorrencyConversionBean retriveCorrencyBeanFeigh(@PathVariable String from,
      @PathVariable String to, @PathVariable BigDecimal quantity
  ){
      CorrencyConversionBean response = proxy.retriveExchangeValue(from, to);
    return new CorrencyConversionBean(response.getId(), from, to, quantity,quantity.multiply(response.getConversionMultiple()),
        response.getConversionMultiple(),response.getPort());
  }

```



add open-feign dependency, build proxy interface to call service. add ribbon dependency to load banlance

step 6: using naming server Eureka. 

With naming server, you can not hard-code the url in propery file:

```
spring.application.name= currency-conversion-service
server.port=8100
eureka.client.service-url.default-zone = http://localhost:8761/eureka
#currency-exchange-service.ribbon.listOfServers = http://localhost:8000, http://localhost:8001

```

step 7: configure ZUUL server

a. please see driver file and application property

b. configure our zuullogger filter

c. call service directly : localhost:8765/{service name}/{uri}

网关的作用相当于外部服务调用时的中转站

step 8: distributing tracing

![image-20201129120428953](C:\Users\fanke\AppData\Roaming\Typora\typora-user-images\image-20201129120428953.png)

1. add depencies to zuul-server and currency-conversion and exchange

   ```
   <dependency>
   		<groupId>org.springframework.cloud</groupId>
   		<artifactId>spring-cloud-starter-sleuth</artifactId>
   	</dependency>
   ```

   2. add bean

      ```
      @Bean
      	public Sampler defaultSampler(){
      		return Sampler.ALWAYS_SAMPLE;
      }
      ```

      

2. install RabbitMq

https://www.cnblogs.com/vaiyanzi/p/9531607.html

3. using zippin to distributed

   gitbash:

   ```
   curl -sSL https://zipkin.io/quickstart.sh | bash -s
   set RABBIT_URI=amqp://localhosts 
   java -jar zipkin.jar
   
   ```

   

run zipkin server:



http://localhost:9411/zipkin/

4. add dependencies:

   ```
   <dependency>
   			<groupId>org.springframework.cloud</groupId>
   			<artifactId>spring-cloud-starter-zipkin</artifactId>
   		</dependency>
   		<dependency>
   			<groupId>org.springframework.amqp</groupId>
   			<artifactId>spring-rabbit</artifactId>
   		</dependency>
   ```

   

step 8:

suppose limit-service have 100+ instances, how could we refresh all the instance at the same time when property change?

**Spring-cloud-bus !**

add one line to bootstrap.property:

```
management.endpoints.web.exposure.include=*
```

 expose all endpoints in /actuator

add dependency:

```
<dependency>
			<groupId>org.springframework.amqp</groupId>
			<artifactId>spring-rabbit</artifactId>
		</dependency>
```

