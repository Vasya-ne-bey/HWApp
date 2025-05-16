package org.skypro.skyshop.searchengine;

import org.skypro.skyshop.exceptions.BestResultNotFound;
import org.skypro.skyshop.searchables.Searchable;

import java.util.ArrayList;

public class SearchEngine {


    private ArrayList<Searchable> searchables;


    public SearchEngine() {
        searchables = new ArrayList<>();
    }


    public Searchable searchOne(String searchableWord) throws BestResultNotFound {

        Searchable bestArticle = null;
        int mostWords = 0;


        for (int i = 0; i < searchables.size(); i++) {          // [product1, product2, article2, ...]

            Searchable searchable = searchables.get(i);

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


    public ArrayList<Searchable> search(String searchTerm) {

        ArrayList<Searchable> resultArrayWithSearchables = new ArrayList<>();

        for (int i = 0; i < searchables.size(); i++) {

            String articleContents = searchables.get(i).getSearchTerm();
            if (articleContents.contains(searchTerm)) {
                resultArrayWithSearchables.add(searchables.get(i));
            }
        }

        return resultArrayWithSearchables;
    }


    public void add(Searchable searchable) {

        searchables.add(searchable);

    }
}
