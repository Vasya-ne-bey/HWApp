package org.skypro.skyshop.searchengine;

import org.skypro.skyshop.exceptions.BestResultNotFound;
import org.skypro.skyshop.searchables.Searchable;

public class SearchEngine {


    // todo ap
    private Searchable[] searchables;


    public SearchEngine(int size) {
        searchables = new Searchable[size];
    }


    public Searchable searchOne(String searchableWord) throws BestResultNotFound {

        Searchable bestArticle = null;
        int mostWords = 0;


        for (int i = 0; i < searchables.length; i++) {          // [product1, null, product2, article2, ...]

            Searchable searchable = searchables[i];

            if (searchable == null) {
                continue;
            }

            String str = searchable.getSearchTerm();

            int amount = 0;
            int newStartIndex = 0;          //  "ld hello jadk jask hello jalks jlas hello jklsj alkjlka dsjlkf sal"

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


    public Searchable[] search(String searchTerm) {            // apple

        Searchable[] results = new Searchable[5];
        int j = 0;

        for (int i = 0; i < searchables.length; i++) {

            if (searchables[i] == null) {
                continue;
            }

            String searchableInfo = searchables[i].getSearchTerm();
            if (searchableInfo.contains(searchTerm)) {
                results[j] = searchables[i];
                j++;
                if (j == 5) {
                    break;
                }
            }
        }

        return results;
    }


    // todo ap
    public void add(Searchable searchable) {
        for (int i = 0; i < searchables.length; i++) {
            if (searchables[i] == null) {
                searchables[i] = searchable;
                break;
            }
        }
    }
}
