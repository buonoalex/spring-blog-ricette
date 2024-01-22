package org.lesson.springblogricette.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String type;

    //Relazione
    @OneToMany(mappedBy = "category")
    private List<Ricetta> ricettaList;

    //Costruttore

    //Metodi

    //Getter and Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Ricetta> getRicettaList() {
        return ricettaList;
    }

    public void setRicettaList(List<Ricetta> ricettaList) {
        this.ricettaList = ricettaList;
    }
}
