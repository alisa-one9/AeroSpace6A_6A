package com.example.aerospace6a_6a;

public class Model {
    private String name;
    private Integer image;
    private String tema;

    public Model(String name, Integer image) {
        this.name = name;
        this.image = image;
    }

    public Model(String tema) {
        this.tema = tema;
    }

    public String getName() {
        return name;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }
}
