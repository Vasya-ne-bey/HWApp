package org.skypro.skyshop;

import java.util.Arrays;

public class SearchEngine {
    private Searchable[] searchables;


    public SearchEngine(int size) {
        searchables = new Searchable[size];
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

    public void add(Searchable searchable) {
        for (int i = 0; i < searchables.length; i++) {
            if (searchables[i] == null) {
                searchables[i] = searchable;
                break;
            }
        }
    }
}
