package com.itfac.amc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.itfac.amc.util.AuditorAwareImpl;

@EnableJpaAuditing(auditorAwareRef = "auditorAware")
@SpringBootApplication
public class AmcApp {
	
	@Bean
    public AuditorAware<String> auditorAware() {
        return new AuditorAwareImpl();
    }

	public static void main(String[] args) {
		SpringApplication.run(AmcApp.class, args);
	}

}
