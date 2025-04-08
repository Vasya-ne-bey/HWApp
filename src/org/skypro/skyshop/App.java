package org.skypro.skyshop;

import basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

public class App {

    public static void main(String[] args) {

        SimpleProduct apple = new SimpleProduct("Яблоко", 20);
        SimpleProduct orange = new SimpleProduct("Апельсин", 30);
        SimpleProduct banana = new SimpleProduct("Банан", 35);
        SimpleProduct peach = new SimpleProduct("Персик", 30);
        DiscountedProduct lemon = new DiscountedProduct("Лимон", 20, 20);
        FixPriceProduct pear = new FixPriceProduct("Груша", 25);

        ProductBasket firstBasket = new ProductBasket();
        ProductBasket secondBasket = new ProductBasket();


        firstBasket.addProduct(apple);
        firstBasket.addProduct(peach);
        firstBasket.addProduct(pear);
        firstBasket.addProduct(lemon);


        firstBasket.printBasket();
        System.out.println();
        System.out.println();

        System.out.println(firstBasket.countTotal());
        System.out.println();
        System.out.println();


        System.out.println("check product: " + firstBasket.checkProduct(apple.getName()));


        System.out.println(firstBasket.checkProduct(lemon.getName()));

        firstBasket.addProduct(lemon);


        secondBasket.addProduct(apple);
        secondBasket.addProduct(apple);
        secondBasket.addProduct(apple);

        secondBasket.printBasket();

        secondBasket.cleanBasket();

        secondBasket.printBasket();

        secondBasket.countTotal();

        System.out.println(secondBasket.checkProduct(apple.getName()));

    }
}
