package org.skypro.skyshop.searchables.product;

import org.skypro.skyshop.searchables.Searchable;

public abstract class Product implements Searchable {
    private String name;


    public Product(String name) {



        if (name == null) {
            throw new IllegalArgumentException("Передано значение null");
        }  else if (name.isBlank()) {
            throw new IllegalArgumentException ("Передано пустое значение");
        }

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



