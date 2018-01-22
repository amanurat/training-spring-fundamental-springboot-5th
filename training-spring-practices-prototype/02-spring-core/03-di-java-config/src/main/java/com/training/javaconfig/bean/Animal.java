package com.training.javaconfig.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//TODO mark bean component
@Component
@Scope("prototype")
public class Animal implements InitializingBean, DisposableBean {
    private String name = "JOJO";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("call afterPropertiesSet");
    }

    public void destroy() throws Exception {
        System.out.println("call destroy...");
    }
}
