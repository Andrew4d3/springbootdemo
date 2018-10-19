package com.andrew.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;
import java.util.UUID;

public class Student {
    private final UUID id;
    private final Integer age;
    private final String firstName;
    private final String lastName;
    private final String course;

    public Student(@JsonProperty("id") UUID id,
                   @JsonProperty("age") Integer age,
                   @JsonProperty("first a e") String firstName,
                   @JsonProperty("lastName") String lastName,
                   @JsonProperty("course") String course) {
        this.id = id == null ? UUID.randomUUID() : id;
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
        this.course = course;
    }

    public Student(UUID id, Map<String, Object> studentMap) {
        this.id  = id;
        this.age = (Integer) studentMap.get("age");
        this.firstName = (String) studentMap.get("firstName");
        this.lastName = (String) studentMap.get("lastName");
        this.course = (String) studentMap.get("course");
    }

    public UUID getId() {
        return id;
    }

    public Integer getAge() {
        return age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCourse() {
        return course;
    }
}
