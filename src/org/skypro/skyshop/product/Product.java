package org.skypro.skyshop.product;

import org.skypro.skyshop.Searchable;

public abstract class Product implements Searchable {
    private String name;


    public Product(String name) {
        this.name = name;
    }

    public abstract int getPrice();

    public String getName() {
        return name;
    }


    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                '}';

    }

    public abstract boolean isSpecial();

    @Override
    public String getSearchTerm() {
        return name;
    }

    @Override
    public String getContentType() {
        return "PRODUCT";
    }

}



