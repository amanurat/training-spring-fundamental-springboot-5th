package com.training.javaconfig.bean;

import org.springframework.stereotype.Component;

//TODO mark bean component
@Component

//TODO config scope

public class Human {

    private String name = "Assanai Manurat";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
