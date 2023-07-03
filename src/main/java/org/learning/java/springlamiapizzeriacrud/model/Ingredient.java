package org.learning.java.springlamiapizzeriacrud.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "ingredient")
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @ManyToMany(mappedBy = "ingredients", cascade = {CascadeType.REMOVE})
    private List<Pizza> pizzas;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPizzas(List<Pizza> pizzas) {
        this.pizzas = pizzas;
    }
}
