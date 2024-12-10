package pe.edu.certus.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ApiGatewayApplication {
    public static void main(String[] args) {
        System.setProperty("spring.main.web-application-type", "reactive");
        SpringApplication.run(ApiGatewayApplication.class, args);
    }
}