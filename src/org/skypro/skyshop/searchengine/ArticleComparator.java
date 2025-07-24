package org.skypro.skyshop.searchengine;

import org.skypro.skyshop.searchables.Searchable;
import org.skypro.skyshop.searchables.article.Article;
import org.skypro.skyshop.searchables.product.Product;

import java.util.Comparator;

public class ArticleComparator<T> implements Comparator<T> {

    @Override
    public int compare(T s1, T s2) {

        String s1Name;
        String s2Name;

        if (s1 instanceof Product) {
            s1Name = ((Product)s1).getName();
        } else {
            s1Name = ((Article)s1).getArticleName();
        }

        if (s2 instanceof Product) {
            s2Name = ((Product)s2).getName();
        } else {
            s2Name = ((Article)s2).getArticleName();
        }

        if (s1Name.length() > s2Name.length()) {
            return -1;
        }
        else if (s1Name.length() < s2Name.length()) {
            return 1;
        }
        else {
            int compareResult = s1Name.compareTo(s2Name);
            return compareResult;
        }
    }


}
