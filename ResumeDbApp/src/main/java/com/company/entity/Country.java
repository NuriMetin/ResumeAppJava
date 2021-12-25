package com.company.entity;

import lombok.Data;

import java.util.Objects;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return id == country.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return name + " ("+ nationality+")" ;
    }
}
