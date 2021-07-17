package com.duylv.springdiscovery;

import com.duylv.springdiscovery.dto.RoleDTO;
import com.duylv.springdiscovery.entity.Home;
import com.duylv.springdiscovery.entity.Role;
import com.duylv.springdiscovery.entity.User;
import com.duylv.springdiscovery.mapper.RoleMapper;
import com.duylv.springdiscovery.service.RestTemplateService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.persistence.criteria.SetJoin;
import java.time.LocalDate;
import java.time.LocalTime;

@SpringBootApplication
public class SpringDiscoveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDiscoveryApplication.class, args);
	}

	@Bean
	public CommandLineRunner lookup() {
		return args -> {

		};
	}

}
