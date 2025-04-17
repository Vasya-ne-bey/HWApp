package org.skypro.skyshop;

import basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;

import javax.naming.directory.SearchControls;
import java.util.Arrays;

public class App {

    public static void main(String[] args) {

        SimpleProduct apple = new SimpleProduct("Яблоко", 20);
        SimpleProduct orange = new SimpleProduct("Апельсин", 30);
        SimpleProduct banana = new SimpleProduct("Банан", 35);
        SimpleProduct peach = new SimpleProduct("Персик", 30);
        DiscountedProduct lemon = new DiscountedProduct("Лимон", 20, 20);
        FixPriceProduct pear = new FixPriceProduct("Груша", 25);
        Article aboutApple = new Article(" Вкусное яблоко ", " Яблоко ");
        ProductBasket firstBasket = new ProductBasket();
        ProductBasket secondBasket = new ProductBasket();


        //-------------------


        System.out.println();
        System.out.println("===-------");

        Article article = new Article("content1", "name1");
        System.out.println(article.getStringRepresentation());

        SearchEngine engine = new SearchEngine(10);
        engine.add(aboutApple);
        engine.add(lemon);
        engine.add(apple);

        Searchable[] results = engine.search("Яблоко");
        System.out.println(Arrays.toString(results));

    }
}