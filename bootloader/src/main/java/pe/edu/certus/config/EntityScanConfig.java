package pe.edu.certus.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EntityScan(basePackages = {"pe.edu.certus.persistence"})
public class EntityScanConfig {
}
