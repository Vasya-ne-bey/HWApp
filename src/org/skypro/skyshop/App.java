package org.skypro.skyshop;


import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.searchables.Searchable;
import org.skypro.skyshop.searchables.article.Article;
import org.skypro.skyshop.searchables.product.DiscountedProduct;
import org.skypro.skyshop.searchables.product.Product;
import org.skypro.skyshop.searchables.product.SimpleProduct;
import org.skypro.skyshop.searchengine.SearchEngine;

import java.util.List;
import java.util.Set;

public class App {



    public static void main(String[] args) {


        basketDeleteDemo();


        SimpleProduct apple = new SimpleProduct("яблоко", 20);
        SimpleProduct pineapple = new SimpleProduct("ананас", 40);
        DiscountedProduct lemon = new DiscountedProduct("лимоны", 20, 20);
        Article aboutApple = new Article("вкусное яблоко", "яблоко гала");

        SearchEngine engine = new SearchEngine();

        engine.add(aboutApple);
        engine.add(lemon);
        engine.add(apple);
        engine.add(pineapple);


       Set<Article> set1 = engine.search("яблоко");
        System.out.println(set1);
        System.out.println();
        System.out.println();

        Set<Article> set2 = engine.search("ананас");
        System.out.println(set2);
        System.out.println();
        System.out.println();

        Set<Article> set3 = engine.search("л");
        System.out.println(set3);


    }

    private static void basketDeleteDemo() {
        ProductBasket basket = new ProductBasket();


        Product coconut = new SimpleProduct("coconut", 150);
        Product carrot = new SimpleProduct("carrot", 10);

        basket.addProduct(coconut);
        basket.addProduct(carrot);

        basket.printBasket();

        List<Product> deletedProducts = basket.deleteProductByName("carrot");
        System.out.println("Список удалённых продуктов:");
        System.out.println(deletedProducts);


        System.out.println();
        System.out.println("Содержимое корзины:");
        basket.printBasket();
        System.out.println("Сумма");
        System.out.println(basket.countTotalSum());

    }

}
