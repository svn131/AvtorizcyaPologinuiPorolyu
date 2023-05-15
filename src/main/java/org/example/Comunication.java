package org.example;


import org.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class Comunication {

    @Autowired
    private RestTemplate restTemplate;
    private final String URL =  "http://localhost:8080/adminProfile";


    public List<User> showAllUser(){
        ResponseEntity<List<User>> responseEntity = restTemplate.exchange(URL, HttpMethod.GET, null, new ParameterizedTypeReference<List<User>>() {
        });
List<User> allUserList = responseEntity.getBody();
        return allUserList;
    }


    public User getUser(Long id){
        return null;
    }

    public void saveUsr(User user){

    }

    public void dleteUser(Long id){

    }

}
