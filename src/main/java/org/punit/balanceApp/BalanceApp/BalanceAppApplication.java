package org.punit.balanceApp.BalanceApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class BalanceAppApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(BalanceAppApplication.class, args);
	}

}
