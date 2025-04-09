package org.skypro.skyshop.product;

public abstract class Product {
    private String name;

//    public Product() {}

    public Product(String name) {
        this.name = name;
    }

    public abstract int getPrice();         //  abstract Building        House       Factory     School

    public String getName() {
        return name;
    }


    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                '}';
    }


    }

