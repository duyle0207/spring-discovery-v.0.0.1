package com.duylv.springdiscovery.config;

import com.duylv.springdiscovery.util.BuilderUtil;

import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Configuration
@EnableJpaAuditing
public class WebConfiguration {

    @PersistenceContext
    private EntityManager entityManager;

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", BuilderUtil.corsConfigurationBuilder());

        return new CorsFilter(source);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public CustomAuditorAware auditorProvider(){
        return new CustomAuditorAware();
    }

    @Bean
    public JPAQuery<?> jpaQuery() {
        return new JPAQuery<>(entityManager);
    }

}
