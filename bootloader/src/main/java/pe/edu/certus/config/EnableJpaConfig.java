package pe.edu.certus.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = {"pe.edu.certus.persistence"})
public class EnableJpaConfig {
}
