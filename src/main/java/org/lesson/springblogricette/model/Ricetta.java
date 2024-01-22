package org.lesson.springblogricette.model;

import jakarta.persistence.*;

@Entity
public class Ricetta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String title;

    @Lob
    @Column(nullable = false)
    private String textIngridients;

    @Lob
    private String picture_url;

    @Column(nullable = false)
    private int timeRecipe;

    private int numberPortions;

    private String textRecipe;

    //Costruttore

    //Metodi

    //Getter and Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTextIngridients() {
        return textIngridients;
    }

    public void setTextIngridients(String textIngridients) {
        this.textIngridients = textIngridients;
    }

    public String getPicture_url() {
        return picture_url;
    }

    public void setPicture_url(String picture_url) {
        this.picture_url = picture_url;
    }

    public int getTimeRecipe() {
        return timeRecipe;
    }

    public void setTimeRecipe(int time) {
        this.timeRecipe = time;
    }

    public int getNumberPortions() {
        return numberPortions;
    }

    public void setNumberPortions(int numberPortions) {
        this.numberPortions = numberPortions;
    }

    public String getTextRecipe() {
        return textRecipe;
    }

    public void setTextRecipe(String textRecipe) {
        this.textRecipe = textRecipe;
    }
}
