package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {

    private int price;
    private int discount;

    public DiscountedProduct(String name, int price, int discount) {
        super(name);

        if (price < 1) {
            throw new IllegalArgumentException("Цена недействительна");
        }

        if (discount < 0 || discount > 100) {
            throw new IllegalArgumentException("Скидка недействительна");
        }

        this.price = price;
        this.discount = discount;
    }


    @Override
    public int getPrice() {
        return price - discount / 100 * price;
    }

    public int getDiscount() {
        return discount;
    }

    @Override
    public String toString() {
        return getName() + ": " + price + " (" + discount + "%)";
    }

    @Override
    public boolean isSpecial() {
        return true;
    }
}
