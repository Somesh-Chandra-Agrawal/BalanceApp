package org.punit.balanceApp.BalanceApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"org.punit.balanceApp.BalanceApp.Services"})
@EntityScan("org.punit.balanceApp.BalanceApp.Data")
@EnableJpaRepositories("org.punit.balanceApp.BalanceApp.Repo")
public class BalanceAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(BalanceAppApplication.class, args);
	}

}
