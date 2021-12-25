package com.company.entity;

import lombok.Data;

@Data
public class Country {

    private int id;
    private String name;
    private String nationality;

    public Country(int id, String name, String nationality) {
        this.id = id;
        this.name = name;
        this.nationality = nationality;
    }

    @Override
    public String toString() {
        return name + " ("+ nationality+")" ;
    }
}
