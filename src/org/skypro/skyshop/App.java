package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.exceptions.BestResultNotFound;
import org.skypro.skyshop.searchables.Searchable;
import org.skypro.skyshop.searchables.article.Article;
import org.skypro.skyshop.searchables.product.DiscountedProduct;
import org.skypro.skyshop.searchables.product.FixPriceProduct;
import org.skypro.skyshop.searchables.product.Product;
import org.skypro.skyshop.searchables.product.SimpleProduct;
import org.skypro.skyshop.searchengine.SearchEngine;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class App {



    public static void main(String[] args) {


        SimpleProduct apple = new SimpleProduct("Яблоко", 20);
        DiscountedProduct lemon = new DiscountedProduct("Лимон", 20, 20);
        Article aboutApple = new Article(" Вкусное яблоко  ", " Яблоко ");

        SearchEngine engine = new SearchEngine();

        engine.add(aboutApple);
        engine.add(lemon);
        engine.add(apple);


       Map<String, Searchable> map1 = engine.search("Яблоко");
        System.out.println(map1);


    }

}
