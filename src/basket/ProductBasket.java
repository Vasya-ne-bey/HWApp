package basket;


import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
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
                continue;
            }

            int price = product.getPrice();
            sum = sum + price;
        }
        return sum;

    }

    public void printBasket() {

        int countSpecial = 0;

        for (int i = 0; i < products.length; i++) {
            Product product = products[i];

            if (product == null) {
                continue;
            }

            System.out.println(product);
            if (product.isSpecial()) {
                countSpecial++;
            }
        }

        System.out.println("Итого: " + countTotal());
        System.out.println(" Специальных товаров: " + countSpecial);
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


