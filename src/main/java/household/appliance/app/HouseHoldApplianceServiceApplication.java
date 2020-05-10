package household.appliance.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages={"household.appliance"})
@EntityScan("household.appliance.entity")
@EnableJpaRepositories("household.appliance.repository")
public class HouseHoldApplianceServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HouseHoldApplianceServiceApplication.class, args);
	}

}
