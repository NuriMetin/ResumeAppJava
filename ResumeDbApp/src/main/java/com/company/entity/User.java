package com.company.entity;

import java.sql.Date;
import java.util.List;

import lombok.Data;

@Data
public class User {

    private int id;
    private String name;
    private String surname;
    private String email;
    private String phone;
    private String profileDescription;
    private String address;
    private Date birthDate;
    private Country nationality;
    private Country birthPlace;
    private List<UserSkill> skills;

    public User() {
    }

    public User(int id) {
        this.id = id;
    }

    public User(int id, String name, String surname, String email, String phone, String profileDescription, String address, Date birthDate, Country nationality, Country birthPlace) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
        this.profileDescription = profileDescription;
        this.address = address;
        this.birthDate = birthDate;
        this.nationality = nationality;
        this.birthPlace = birthPlace;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", profileDescription='" + profileDescription + '\'' +
                ", address='" + address + '\'' +
                ", birthDate=" + birthDate +
                ", nationality=" + nationality +
                ", birthPlace=" + birthPlace +
                '}';
    }
}
