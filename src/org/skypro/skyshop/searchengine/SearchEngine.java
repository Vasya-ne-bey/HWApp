package org.skypro.skyshop.searchengine;

import org.skypro.skyshop.exceptions.BestResultNotFound;
import org.skypro.skyshop.searchables.Searchable;
import org.skypro.skyshop.searchables.article.Article;
import org.skypro.skyshop.searchables.product.Product;

import java.util.*;

public class SearchEngine {


    private Set<Searchable> searchables;


    public SearchEngine() {
        searchables = new HashSet<>();
    }


    public Searchable searchOne(String searchableWord) throws BestResultNotFound {

        Searchable bestArticle = null;
        int mostWords = 0;


        for (Searchable searchable : searchables) {          // [product1, product2, article2, ...]
            // с Set нельзя использовать for, только for each

            String str = searchable.getSearchTerm();


            // считаем сколько раз повторяется слово, и если чаще чем для другого Searchable, то запоминаем этот Searchable

            int amount = 0;
            int newStartIndex;          //  "ld hello jadk jask hello jalks jlas hello jklsj alkjlka dsjlkf sal"

            int substringIndex = str.indexOf(searchableWord);

            while (substringIndex != -1) {
                amount++;
                newStartIndex = substringIndex + searchableWord.length();
                substringIndex = str.indexOf(searchableWord, newStartIndex);
            }

            if (amount > mostWords) {
                bestArticle = searchable;
                mostWords = amount;
            }
        }

        if (bestArticle == null) {
            throw new BestResultNotFound("Не найдено подходящего Searchable для запроса " + searchableWord);
        }


        return bestArticle;
    }


    public Set<Searchable> search(String searchTerm) {


        Comparator<Searchable> searchableComparator = new Comparator<>() {

            public int compare(Searchable s1, Searchable s2) {

                String s1Name;
                String s2Name;

                if (s1 instanceof Product) {
                    s1Name = ((Product)s1).getName();          //    short number = (short)72389732892;
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
        };


        Set<Searchable> resultSetWithSearchables = new TreeSet<>(searchableComparator);

        for (Searchable searchable : searchables) {

            String articleContents = searchable.getSearchTerm();
            if (articleContents.contains(searchTerm)) {
                resultSetWithSearchables.add(searchable);
            }
        }

        return resultSetWithSearchables;
    }


    public void add(Searchable searchable) {

        searchables.add(searchable);

    }
}
