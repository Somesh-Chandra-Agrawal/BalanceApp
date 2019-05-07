package org.punit.balanceApp.BalanceApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"org.punit.balanceApp"})
@EntityScan(basePackages = {"org.punit.balanceApp"})
@ComponentScan(basePackages = {"org.punit.balanceApp"})
public class BalanceAppApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(BalanceAppApplication.class, args);
	}

}
