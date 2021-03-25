package com.afrifanom.inventory;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "tb_shoes")
public class Shoe {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "shoes_tb_sequence")
    private Integer id;

    private String brand;

    private String size;

    private String color;

    private String price;

    public Shoe() {
    }

    public Shoe(Integer id, String brand, String size, String color, String price) {
        this.id = id;
        this.brand = brand;
        this.size = size;
        this.color = color;
        this.price = price;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Shoe{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", size='" + size + '\'' +
                ", price='" + price + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
