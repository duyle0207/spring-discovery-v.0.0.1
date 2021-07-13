package com.duylv.springdiscovery.service.impl;

import com.duylv.springdiscovery.constants.StringConstant;
import com.duylv.springdiscovery.service.RestTemplateService;
import com.duylv.springdiscovery.util.StringUtil;
import org.apache.http.HttpHeaders;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.ssl.TrustStrategy;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.SSLContext;
import javax.print.attribute.standard.Media;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * This Service is used for Customer RestTemplate. We want to add more configurations for RestTemplate
 * such as HttpHeader, HttpClient
 */
@Service
public class RestTemplateServiceImpl implements RestTemplateService {

    private final RestTemplate restTemplate;

    private String token;

    public RestTemplateServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        buildConfiguration(restTemplate);
    }

    @Override
    public void buildConfiguration(RestTemplate restTemplate) {
        List<ClientHttpRequestInterceptor> clientHttpRequestInterceptors = restTemplate.getInterceptors();
        clientHttpRequestInterceptors.add((httpRequest, bytes, clientHttpRequestExecution) -> {
            if (!Objects.isNull(token)) {
                httpRequest.getHeaders().add(HttpHeaders.AUTHORIZATION, token);
            }
            httpRequest.getHeaders().add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
            return clientHttpRequestExecution.execute(httpRequest, bytes);
        });

        restTemplate.setInterceptors(clientHttpRequestInterceptors);
    }

    @Override
    public CloseableHttpClient getHttpClient() throws NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        TrustStrategy trustStrategy = (x509Certificate, s) -> true;
        SSLContext sslContext = SSLContexts
                .custom()
                .loadTrustMaterial(trustStrategy)
                .build();
        SSLConnectionSocketFactory sslConnectionSocketFactory = new SSLConnectionSocketFactory(sslContext, new NoopHostnameVerifier());
        return HttpClients
                .custom()
                .setSSLSocketFactory(sslConnectionSocketFactory)
                .build();
    }

    @Override
    public String getFullUrl(String baseUrl, String uri) {
        return baseUrl.endsWith(StringConstant.FORWARD_SLASH) ?
                StringUtil.concentrateString(baseUrl, uri) :
                StringUtil.concentrateString(baseUrl, StringConstant.FORWARD_SLASH, uri);
    }

    @Override
    public <T> T getForObject(String baseUrl, String url, Class<T> clazz) {
        return restTemplate.getForObject(getFullUrl(baseUrl, url), clazz);
    }

    @Override
    public <T> T getForObject(String baseUrl, String url, Class<T> clazz, Map<String, Object> params) {
        return restTemplate.getForObject(getFullUrl(baseUrl, url), clazz, params);
    }

    @Override
    public <T> ResponseEntity<T> getForEntity(String baseUrl, String url, Class<T> clazz) {
        return restTemplate.getForEntity(getFullUrl(baseUrl, url), clazz);
    }

    @Override
    public <T> ResponseEntity<T> getForEntity(String baseUrl, String url, Class<T> clazz, Object... params) {
        return restTemplate.getForEntity(getFullUrl(baseUrl, url), clazz, params);
    }

    @Override
    public <T> T postForObject(String baseUrl, String url, T t, Class<T> clazz) {
        return null;
    }

    @Override
    public <T> T postForEntity(String baseUrl, String url, T t, Class<T> clazz) {
        return null;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
