//package org.example.model;
//
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//
//import java.util.Objects;
//import java.util.Set;
//
//
//public class User{
//
//    private Long id;
//
//    private String firstName;
//
//    private String lastName;
//
//    private String password;
//    private int age;
//
//    private String email;
//
//
//    private Set<Role> roles;
//
//    public Set<Role> getRoles() {
//        return roles;
//    }
//
//
//
//    public void setRoles(Set<Role> roles) {
//        this.roles = roles;
//    }
//
//
//    public User() {
//    }
//
//    public User(String firstName, String lastName, String password, int age, String email, Set<Role> roles) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.password = password;
//        this.age = age;
//        this.email = email;
//        this.roles = roles;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//
//
//    public void setEmail(String username) {
//        this.email = username;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//
//    @Override
//    public String toString() {
//        return "User{" +
//                "id=" + id +
//                ", firstName='" + firstName + '\'' +
//                ", lastName='" + lastName + '\'' +
//                ", password='" + password + '\'' +
//                ", age=" + age +
//                ", email='" + email + '\'' +
//                ", roles=" + roles +
//                '}';
//    }
//}
