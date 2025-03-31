package org.skypro.skyshop;

import basket.ProductBasket;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

public class App {

    public static void main(String[] args) {

        SimpleProduct apple = new SimpleProduct("Яблоко", 20);
        SimpleProduct orange = new SimpleProduct("Апельсин", 30);
        SimpleProduct banana = new SimpleProduct("Банан", 35);
        SimpleProduct peach = new SimpleProduct("Персик", 30);
        SimpleProduct lemon = new SimpleProduct("Лимон", 20);
        SimpleProduct pear = new SimpleProduct("Груша", 25);

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
