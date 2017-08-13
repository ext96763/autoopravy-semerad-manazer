package com.autoopravy.semerad.manazer.InternalManager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
public class InternalManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(InternalManagerApplication.class, args);
	}

}
