package org.skypro.skyshop;


import org.skypro.skyshop.searchables.Searchable;
import org.skypro.skyshop.searchables.article.Article;
import org.skypro.skyshop.searchables.product.DiscountedProduct;
import org.skypro.skyshop.searchables.product.SimpleProduct;
import org.skypro.skyshop.searchengine.SearchEngine;

import java.util.Set;

public class App {



    public static void main(String[] args) {


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

}
