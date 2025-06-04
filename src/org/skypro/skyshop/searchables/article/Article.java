package org.skypro.skyshop.searchables.article;

import org.skypro.skyshop.searchables.Searchable;

public final class Article implements Searchable {
    private String articleName;
    private String articleContent;

    public Article(String articleContent, String articleName) {
        this.articleContent = articleContent;
        this.articleName = articleName;
    }

    @Override
    public String toString() {
        return articleName + " " + articleContent;

    }


    @Override
    public String getSearchTerm() {
        return toString();
    }

    @Override
    public String getContentType() {
        return "ARTICLE";
    }

    // todo qp equals and hashcode
}



