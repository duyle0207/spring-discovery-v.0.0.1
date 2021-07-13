package com.duylv.springdiscovery.util;

import org.springframework.web.cors.CorsConfiguration;

import java.util.Collections;
import java.util.Map;

public class BuilderUtil {

    /**
     * CorsConfiguration's builder
     * @return CorsConfiguration
     */
    public static CorsConfiguration corsConfigurationBuilder() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowedOriginPatterns(Collections.singletonList("*"));
        corsConfiguration.setAllowedHeaders(Collections.singletonList("*"));
        corsConfiguration.setAllowedMethods(Collections.singletonList("*"));
        corsConfiguration.setAllowCredentials(false);

        return corsConfiguration;
    }

}
