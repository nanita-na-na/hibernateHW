package com.cursor.hibernate.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private int age;
    private String state;

    public User() {
    }

    public User(String firstName, String lastName, int age, String state) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.state = state;
    }

    public User(Long id, String firstName, String lastName, int age, String state) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.state = state;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", state='" + state + '\'' +
                '}';
    }
}
