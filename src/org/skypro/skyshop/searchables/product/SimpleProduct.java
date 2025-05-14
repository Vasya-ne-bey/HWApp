package org.skypro.skyshop.searchables.product;

public class SimpleProduct extends Product {
    private int price;

    public SimpleProduct(String name, int price) {

        super(name);

        if (price < 1) {
            throw new IllegalArgumentException("Цена недействительна");
        }

        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return getName() + ": " + price;
    }

    @Override
    public boolean isSpecial() {
        return false;
    }
}
