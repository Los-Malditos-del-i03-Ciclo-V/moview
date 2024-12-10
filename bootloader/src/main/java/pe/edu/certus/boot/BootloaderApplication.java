package pe.edu.certus.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = {
    "pe.edu.certus.logic", 
    "pe.edu.certus.repository", 
    "pe.edu.certus.api",
    "pe.edu.certus.boot",
    "pe.edu.certus.entities"
})
@EntityScan(basePackages = "pe.edu.certus.entities")
@EnableJpaRepositories(
    basePackages = "pe.edu.certus.repository"
)
public class BootloaderApplication {
    public static void main(String[] args) {
        System.setProperty("spring.main.allow-bean-definition-overriding", "true");
        SpringApplication.run(BootloaderApplication.class, args);
    }
}
