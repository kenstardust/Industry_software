package com.ruoyi.auth.service;


import com.ruoyi.auth.entity.KeycloakTokenResp;
import com.ruoyi.common.redis.service.RedisService;
import com.ruoyi.system.api.model.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.annotation.JsonProperty;


import java.util.concurrent.TimeUnit;

import java.util.concurrent.TimeUnit;

@Service
public class KeycloakSyncService {
    @Value("${keycloak.base-url}")
    private String baseUrl;

    @Value("${keycloak.realm}")
    private String realm;

    @Value("${keycloak.client-id}")
    private String clientId;

    @Value("${keycloak.client-secret}")
    private String clientSecret;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private RedisService redisService;

    public void syncLogin(String username, String password, LoginUser loginUser) {
        String url = baseUrl + "/realms/" + realm + "/protocol/openid-connect/token";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> form = new LinkedMultiValueMap<>();
        form.add("grant_type", "password");
        form.add("client_id", clientId);
        form.add("client_secret", clientSecret);
        form.add("username", username);
        form.add("password", password);

        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(form, headers);

        KeycloakTokenResp resp = restTemplate.postForObject(url, entity, KeycloakTokenResp.class);

        if (resp != null && resp.getAccessToken() != null) {
            String redisKey = "kc:token:" + loginUser.getUserid();
            redisService.setCacheObject(redisKey, resp, resp.getExpiresIn(), TimeUnit.SECONDS);
        }
    }
}
