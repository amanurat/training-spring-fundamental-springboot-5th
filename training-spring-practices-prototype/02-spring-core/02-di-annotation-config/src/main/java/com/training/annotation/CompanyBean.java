package com.training.annotation;

import org.springframework.stereotype.Component;

//TODO mark bean component
@Component
public class CompanyBean {

    private String name = "Facebook";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
