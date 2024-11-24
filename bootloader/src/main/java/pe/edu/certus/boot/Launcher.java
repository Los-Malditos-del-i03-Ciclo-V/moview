package pe.edu.certus.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
        "pe.edu.certus.api",
        "pe.edu.certus.model",
        "pe.edu.certus.boot",
        "pe.edu.certus.libraries",
        "pe.edu.certus.persistence",
        "pe.edu.certus.config",
        "pe.edu.certus.port",
        "pe.edu.certus.adapter",

})
public class Launcher {
    public static void main(String[] args) {
        SpringApplication.run(Launcher.class, args);
    }
}