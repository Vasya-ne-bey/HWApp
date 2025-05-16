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

public class App {



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

        System.out.println();
        List<Product> deletedProducts2 = basket.deleteProductByName("potato");
        System.out.println("Список удалённых продуктов:");
        System.out.println(deletedProducts2);
        if (deletedProducts2.isEmpty()) {
            System.out.println("Список пуст");
        }

        System.out.println();
        System.out.println("Содержимое корзины:");
        basket.printBasket();

    }

    public static void main(String[] args) {


        basketDeleteDemo();

        System.out.println();
        System.out.println("---------basketTest done");
        System.out.println();


        try {

            SimpleProduct apple = new SimpleProduct("Яблоко", 20);
            SimpleProduct orange = new SimpleProduct("Апельсин", 30);
            SimpleProduct banana = new SimpleProduct("Банан", 35);
            SimpleProduct peach = new SimpleProduct("Персик", 30);
            DiscountedProduct lemon = new DiscountedProduct("Лимон", 20, 20);
            FixPriceProduct pear = new FixPriceProduct("Груша", 25);


            Article aboutApple = new Article(" Вкусное яблоко  ", " Яблоко ");

            SearchEngine engine = new SearchEngine();
            engine.add(aboutApple);
            engine.add(lemon);
            engine.add(apple);

            ArrayList<Searchable> results = engine.search("Яблоко");
            System.out.println(results);

            Searchable best = engine.searchOne("дерево");
            System.out.println();
            System.out.println();
            System.out.println("Больше всего подходящих слов в серчабл:");
            System.out.println(best);

        } catch (BestResultNotFound e) {
            System.out.println(e.getMessage());
        }

        try {
            SimpleProduct apple = new SimpleProduct("Яблоко", 20);
            SimpleProduct orange = new SimpleProduct("Апельсин", 30);
            SimpleProduct banana = new SimpleProduct("Банан", 35);
            SimpleProduct peach = new SimpleProduct("Персик", 30);
            DiscountedProduct lemon = new DiscountedProduct("Лимон", 20, 20);
            FixPriceProduct pear = new FixPriceProduct("Груша", 25);

            Article aboutApple = new Article(" Вкусное яблоко  ", " Яблоко ");
            Article article = new Article("content1", "name1");
            System.out.println(article.getStringRepresentation());

            SearchEngine engine = new SearchEngine();


            ArrayList<Searchable> results = engine.search("яблоко");
            System.out.println(results);
            engine.add(aboutApple);
            engine.add(lemon);
            engine.add(apple);
            Searchable best = engine.searchOne("Яблоко");
            System.out.println();
            System.out.println();
            System.out.println("Больше всего подходящих слов в серчабл:");
            System.out.println(best);

        } catch (BestResultNotFound e) {
            System.out.println(e.getMessage());
        }

    }

}
