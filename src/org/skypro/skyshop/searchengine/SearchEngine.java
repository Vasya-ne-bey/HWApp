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


        ArticleComparator<Searchable> searchableArticleComparator = new ArticleComparator<>();


        Set<Searchable> resultSetWithSearchables = new TreeSet<>(searchableArticleComparator);

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
