package com.sacavix.hellospringwebflux;

public class Phone {

    private Long id;
    private String name;

    public Phone() {
    }
    public Phone(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
