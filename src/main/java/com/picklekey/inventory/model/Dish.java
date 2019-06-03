package com.picklekey.inventory.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import java.io.Serializable;

@Entity
@Table(name="dish")
public class Dish implements Serializable{

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="dish_id")
    private int id;

    @Column(name="dish_name")
    private String dishName;

    @Column(name="dish_type")
    private String dishType;

    @Column(name="dish_category")
    private String dishCategory;

    @Column(name="dish_cost")
    private String dishCost;

    public Dish() {
    }

    public Dish(String dishName, String dishType, String dishCategory, String dishCost) {
        this.dishName = dishName;
        this.dishType = dishType;
        this.dishCategory = dishCategory;
        this.dishCost = dishCost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public String getDishType() {
        return dishType;
    }

    public void setDishType(String dishType) {
        this.dishType = dishType;
    }

    public String getDishCategory() {
        return dishCategory;
    }

    public void setDishCategory(String dishCategory) {
        this.dishCategory = dishCategory;
    }

    public String getDishCost() {
        return dishCost;
    }

    public void setDishCost(String dishCost) {
        this.dishCost = dishCost;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "id=" + id +
                ", dishName='" + dishName + '\'' +
                ", dishType='" + dishType + '\'' +
                ", dishCategory='" + dishCategory + '\'' +
                ", dishCost='" + dishCost + '\'' +
                '}';
    }
}
