package com.company.entity;

import lombok.Data;

@Data
public class Skill {
    private int id;
    private String name;

    public  Skill(){

    }

    public Skill(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Skill{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
