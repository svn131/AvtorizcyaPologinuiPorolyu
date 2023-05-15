package org.example;



import org.apache.tomcat.util.codec.binary.Base64;
import org.example.model.User;
import org.example.model.User1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;



import java.nio.charset.StandardCharsets;
import java.util.List;



@Component
public class Comunication {

    @Autowired
    private RestTemplate restTemplate;
    private final String URL =  "http://94.198.50.185:7081/api/users";
    private final String URL2 =  "http://localhost:8080/adminProfile";

    private String sessionId = "";



//    public List<User1> showAllUser() {
//        ResponseEntity<List<User1>> responseEntity = restTemplate.exchange(URL2, HttpMethod.GET, null, new ParameterizedTypeReference<List<User1>>() {
//        });
//        List<User1> allUserList = responseEntity.getBody();
//        return allUserList;
//
//    }







    //авторизация погину и паролю из своеже задачи 3-1-5 и получаю пакет джейсон
public List<User1> showAllUser() {
    String login = "admin@mail.ru";
    String password = "1111";
    String auth = login + ":" + password;
    byte[] encodedAuth = org.apache.commons.codec.binary.Base64.encodeBase64(auth.getBytes(StandardCharsets.UTF_8));
    String authHeader = "Basic " + new String(encodedAuth);

    HttpHeaders headers = new HttpHeaders();
    headers.set("Authorization", authHeader);
    HttpEntity<String> entity = new HttpEntity<>(headers);

    ResponseEntity<List<User1>> responseEntity = restTemplate.exchange(URL, HttpMethod.GET, entity, new ParameterizedTypeReference<List<User1>>() {});
    List<User1> allUserList = responseEntity.getBody();
    return allUserList;
}









//
////    public ResponseEntity<List<User>> showAllUser() {
////        ResponseEntity<List<User>> responseEntity = restTemplate.exchange(URL, HttpMethod.GET, null, new ParameterizedTypeReference<List<User>>() {});
////        HttpHeaders headers = responseEntity.getHeaders();
////        sessionId = headers.getFirst(HttpHeaders.SET_COOKIE);
////        System.out.println(sessionId);
////        List<User> allUserList = responseEntity.getBody();
////        return responseEntity;
////    }
//
//
//
//    public User getUser(Long id) {
//        HttpHeaders headers = new HttpHeaders();
//        headers.add(HttpHeaders.COOKIE, sessionId);
//        HttpEntity<String> requestEntity = new HttpEntity<>(headers);
//
//        String url = URL + "/" + id;
//
//        ResponseEntity<User> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, User.class);
//        return responseEntity.getBody();
//    }
//
//
//
//
//    public ResponseEntity<String> saveUser(User user) {
//        String url = URL;
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        headers.add(HttpHeaders.COOKIE, sessionId);
//        HttpEntity<User> requestEntity = new HttpEntity<>(user, headers);
//
//        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
//        String responseBody = responseEntity.getBody();
//        System.out.println("Response body: " + responseBody);
//        return responseEntity;
//    }
//
//    public ResponseEntity<String> updateUser(User updatedUser) {
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        headers.add(HttpHeaders.COOKIE, sessionId);
//        HttpEntity<User> requestEntity = new HttpEntity<>(updatedUser, headers);
//        ResponseEntity<String> responseEntity = restTemplate.exchange(URL, HttpMethod.PUT, requestEntity, String.class);
//        String responseBody = responseEntity.getBody();
//        System.out.println("Response body: " + responseBody);
//        return responseEntity;
//    }
//
//
//
//    public ResponseEntity<String> deleteUser(Long userId) {
//        String url = URL + "/" + userId;
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        headers.add(HttpHeaders.COOKIE, sessionId);
//        HttpEntity<String> requestEntity = new HttpEntity<>(headers);
//        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.DELETE, requestEntity, String.class);
//        String responseBody = responseEntity.getBody();
//        System.out.println("Response body: " + responseBody);
//        return responseEntity;
//    }



}
