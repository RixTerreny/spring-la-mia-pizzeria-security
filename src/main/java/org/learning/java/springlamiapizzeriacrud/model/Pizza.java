package org.learning.java.springlamiapizzeriacrud.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "pizza")
public class Pizza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String name;
    private String description;
    @Column(nullable = false)
    private double price;
    @Column(name = "img_url")
    private String imgUrl;

    @OneToMany(mappedBy = "pizza", cascade = {CascadeType.REMOVE})
    private List<Discount> discounts;

    @ManyToMany()
    @JoinTable(
            name = "pizza_ingredients",
            joinColumns = @JoinColumn(name = "pizza_id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id")
    )
    private List<Ingredient> ingredients;

    public Integer getId() {
        return id;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Discount> getDiscounts() {
        return discounts;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDiscounts(List<Discount> discounts) {
        this.discounts = discounts;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
