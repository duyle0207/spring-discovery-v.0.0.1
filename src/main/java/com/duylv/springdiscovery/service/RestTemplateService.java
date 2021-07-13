package com.duylv.springdiscovery.service;

import org.apache.http.impl.client.CloseableHttpClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

public interface RestTemplateService {

    void buildConfiguration(RestTemplate restTemplate);

    CloseableHttpClient getHttpClient() throws NoSuchAlgorithmException, KeyStoreException, KeyManagementException;

    String getFullUrl(String baseUrl, String uri);

    <T> T getForObject(String baseUrl, String url, Class<T> clazz);

    <T> T getForObject(String baseUrl, String url, Class<T> clazz, Map<String, Object> params);

    <T> ResponseEntity<T> getForEntity(String baseUrl, String url, Class<T> clazz);

    <T> ResponseEntity<T> getForEntity(String baseUrl, String url, Class<T> clazz, Object... params);

    <T> T postForObject(String baseUrl, String url, T t, Class<T> clazz);

    <T> T postForEntity(String baseUrl, String url, T t, Class<T> clazz);

}
