package com.duylv.springdiscovery;

import com.duylv.springdiscovery.dto.RoleDTO;
import com.duylv.springdiscovery.entity.Role;
import com.duylv.springdiscovery.mapper.RoleMapper;
import com.duylv.springdiscovery.service.RestTemplateService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringDiscoveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDiscoveryApplication.class, args);
	}

	@Bean
	public CommandLineRunner lookup(RoleMapper roleMapper) {
		return args -> {
			Role role = new Role();
			role.setRoleName("roleName");

			RoleDTO roleDTO = roleMapper.toDto(role);

			System.out.println(roleDTO);

//			String result = restTemplateService.getForObject("http://localhost:8080","/api/public/lst-user", String.class);
//			System.out.println(result);
		};
	}

}
