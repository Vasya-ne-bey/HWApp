package org.skypro.skyshop;

import basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {

    public static void main(String[] args) {

        Product apple = new Product("Яблоко", 20);
        Product orange = new Product("Апельсин", 30);
        Product banana = new Product("Банан", 35);
        Product peach = new Product("Персик", 30);
        Product lemon = new Product("Лимон", 20);
        Product pear = new Product("Груша", 25);

        ProductBasket firstBasket = new ProductBasket();
        ProductBasket secondBasket = new ProductBasket();
        ProductBasket thirdBasket = new ProductBasket();

        firstBasket.addProduct(apple);
        firstBasket.addProduct(orange);
        firstBasket.addProduct(banana);
        firstBasket.addProduct(peach);
        firstBasket.addProduct(pear);

        System.out.println(firstBasket.countTotal());

        firstBasket.printBasket();


        System.out.println(firstBasket.checkProduct(apple.getName()));


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




// Печать содержимого корзины с несколькими товарами.
// Получение стоимости корзины с несколькими товарами.
// Поиск товара, который есть в корзине.
// Поиск товара, которого нет в корзине.
//  Очистка корзины.
//  Печать содержимого пустой корзины.
// Получение стоимости пустой корзины.
// Поиск товара по имени в пустой корзине.
