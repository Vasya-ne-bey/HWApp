package org.skypro.skyshop.product;

public class SimpleProduct extends Product {
    private int price;

    public SimpleProduct(String name, int price) {
        super(name);            // класс SimpleProduct передаёт название продукта своему родителю Product через слово super, так как сам SimpleProduct не имеет поля name
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
