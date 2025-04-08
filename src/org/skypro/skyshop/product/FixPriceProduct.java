package org.skypro.skyshop.product;

public class FixPriceProduct extends Product {

    private String name;

    public FixPriceProduct(String name, int price) {
        super(name);
    }

    private static final int FIX_PRICE = 25;

    @Override
    public int getPrice() {
        return FIX_PRICE;
    }

    @Override
    public String toString() {
        return getName() + ": Фиксированная цена " + FIX_PRICE;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }
}
