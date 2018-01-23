package com.leha.provider;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.leha.model.*;
import lombok.SneakyThrows;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Provider {

    private static final Provider provider = new Provider();
    private static final String BASE_URL = "http://localhost:8080/";
    private String sessionId;
    private RegistrationRequest registrationRequest;
    private Map headers;

    private Provider() {
        registrationRequest = new RegistrationRequest();
        headers = new HashMap();
    }

    public static Provider getInstance(){
        return provider;
    }

    public Object register(RegistrationRequest request){
        String url = BASE_URL + "users/register/";
        headers.clear();
        headers.put("Authorization", sessionId);
        Object o = exshange(url,headers,HttpMethod.POST,request, RegistrationResponse.class);
        try {
            sessionId = ((RegistrationResponse)o).getSessionId();
        }catch (Exception e){}
        return o;
    }

    public  Object login(LoginRequest request){
        String url = BASE_URL + "users/login/";
        headers.clear();
        headers.put("Authorization", sessionId);
        Object o = exshange(url,headers,HttpMethod.POST,request, RegistrationResponse.class);
        try {
            sessionId = ((RegistrationResponse)o).getSessionId();
        }catch (Exception e){}
        return o;
    }

    public Object logout(){
        String url = BASE_URL + "users/logout/";
        headers.clear();
        headers.put("Authorization", sessionId);
        return exshange(url,headers,HttpMethod.POST,null, null);
    }

    public Object getAllUsers(){
        String url = BASE_URL + "users/";
        headers.clear();
        headers.put("Authorization", sessionId);
        return exshange(url,headers,HttpMethod.GET,null, String.class);
    }

    public Object getUserById(String id){
        String url = BASE_URL + "users/" + id + "/";
        headers.clear();
        headers.put("Authorization", sessionId);
        return exshange(url,headers,HttpMethod.GET,null, String.class);
    }

    public Object updateUser(UpdateRequest request,String id){
        String url = BASE_URL + "users/" + id + "/";
        headers.clear();
        headers.put("Authorization", sessionId);
        return exshange(url,headers,HttpMethod.PUT,request, UserWeb.class);
    }

    @SneakyThrows
    private Object exshange(String url,
                                   Map<String,String> headers,
                                   HttpMethod method,
                                   Object request,
                                   Class Response){
        Object res = null;
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        headers.forEach((k,v)->httpHeaders.add(k,v));
        HttpEntity entity = new HttpEntity(request,httpHeaders);
        try{
             ResponseEntity responseEntity = restTemplate.exchange(url, method, entity, Response);
            if(Response != null){
                res = responseEntity.getBody();
            }else {
                res = responseEntity.getStatusCode();
            }
        }catch (HttpStatusCodeException e){
            String err =  e.getResponseBodyAsString();
            res = new ObjectMapper().readValue(err,OuterErrorResponce.class);
        }
        return res;
    }

}
