package org.skypro.skyshop.searchengine;

import org.skypro.skyshop.searchables.Searchable;
import org.skypro.skyshop.searchables.article.Article;
import org.skypro.skyshop.searchables.product.Product;

import java.util.Comparator;

public class ArticleComparator implements Comparator<Article> {

    @Override
    public int compare(Article article1, Article article2) {

        String article1Name = article1.getArticleName();
        String article2Name = article2.getArticleName();


        if (article1Name.length() > article2Name.length()) {
            return -1;
        }
        else if (article1Name.length() < article2Name.length()) {
            return 1;
        }
        else {
            int compareResult = article1Name.compareTo(article2Name);
            return compareResult;
        }
    }


}
