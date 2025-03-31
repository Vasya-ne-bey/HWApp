package basket;


import org.skypro.skyshop.product.Product;

import java.util.Arrays;

public class ProductBasket {

    private Product[] products = new Product[5];


    public boolean checkProduct(String wantedName) {
        for (int i = 0; i < products.length; i++) {
            if (products[i] == null) {
                return false;
            }
            if (wantedName.equals(products[i].getName())) {
                return true;
            }
        }
        return false;
    }


    public void addProduct(Product newItem) {
        for (int i = 0; i <= products.length; i++) {
            if (i == products.length) {
                System.out.println(" Корзина переполнена ");
                break;
            }
            if (products[i] == null) {
                products[i] = newItem;
                return;
            }
        }
    }

    public int countTotal() {

        int sum = 0;
        for (int i = 0; i < products.length; i++) {
            Product product = products[i];
            if (product == null) {
                System.out.println(" 0 ");
            } else {
                int price = product.getPrice();
                sum = sum + price;
            }
        }
        return sum;

    }

    public void printBasket() {

        for (int i = 0; i < products.length; i++) {
            Product product = products[i];
            if (product == null) {
                System.out.println(" null ");
            } else {
                int price = product.getPrice();
                String name = product.getName();
                System.out.println(name + ": " + price);
            }
        }
    }

    public void cleanBasket() {

        for (int i = 0; i < products.length; i++) {
            if (products[i] != null) {
                products[i] = null;
            }
        }
        System.out.println(" Корзина очищена ");
    }

}


