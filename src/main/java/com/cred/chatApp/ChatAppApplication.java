package com.cred.chatApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
		exclude = {
				org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration.class,
				org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration.class,
				org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration.class
		}
)
public class ChatAppApplication {
	public static void main(String[] args) {
		SpringApplication.run(ChatAppApplication.class, args);
	}
}

