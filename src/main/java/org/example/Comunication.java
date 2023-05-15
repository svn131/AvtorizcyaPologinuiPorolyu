package org.example;


import jakarta.servlet.http.HttpServletRequest;
import org.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Component
public class Comunication {

    @Autowired
    private RestTemplate restTemplate;
    private final String URL =  "http://94.198.50.185:7081/api/users";
//    private final String URL =  "http://localhost:8080/adminProfile";

    private String sessionId = "";





    public ResponseEntity<List<User>> showAllUser() {
        ResponseEntity<List<User>> responseEntity = restTemplate.exchange(URL, HttpMethod.GET, null, new ParameterizedTypeReference<List<User>>() {});
        HttpHeaders headers = responseEntity.getHeaders();
        sessionId = headers.getFirst(HttpHeaders.SET_COOKIE);
        System.out.println(sessionId);
        List<User> allUserList = responseEntity.getBody();
        return responseEntity;
    }


//    public List<User> showAllUser(){
//
//        ResponseEntity<List<User>> responseEntity = restTemplate.exchange(URL, HttpMethod.GET, null, new ParameterizedTypeReference<List<User>>() {
//        });
//        List<User> allUserList = responseEntity.getBody();
//        return allUserList;
//    }


//    public User getUser(Long id){
//        return null;
//    }

    public User getUser(Long id) {
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.COOKIE, sessionId);
        HttpEntity<String> requestEntity = new HttpEntity<>(headers);

        String url = URL + "/" + id;

        ResponseEntity<User> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, User.class);
        return responseEntity.getBody();
    }




//    public void saveUser(User user){
//
//    }

//    public String saveUser(User user) {
//        String url = URL;
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        headers.add(HttpHeaders.COOKIE, sessionId);
//        HttpEntity<User> requestEntity = new HttpEntity<>(user, headers);
//
//        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
//        if (responseEntity.getStatusCode() == HttpStatus.CREATED) {
//            return responseEntity.getBody();
//        } else {
//            return null;
//        }
//    }


    public ResponseEntity<String> saveUser(User user) {
        String url = URL;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add(HttpHeaders.COOKIE, sessionId);
        HttpEntity<User> requestEntity = new HttpEntity<>(user, headers);

        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
        String responseBody = responseEntity.getBody();
        System.out.println("Response body: " + responseBody);
        return responseEntity;
    }

    public ResponseEntity<String> updateUser(User updatedUser) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add(HttpHeaders.COOKIE, sessionId);
        HttpEntity<User> requestEntity = new HttpEntity<>(updatedUser, headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(URL, HttpMethod.PUT, requestEntity, String.class);
        String responseBody = responseEntity.getBody();
        System.out.println("Response body: " + responseBody);
        return responseEntity;
    }



    public void dleteUser(Long id){
    }

}
