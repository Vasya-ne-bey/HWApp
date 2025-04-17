package org.skypro.skyshop;

public final class Article implements Searchable {
    private String articleName;
    private String articleContent;

    public Article(String articleContent, String articleName) {
        this.articleContent = articleContent;
        this.articleName = articleName;
    }

    @Override
    public String toString() {
        return articleName + "\n" + articleContent;

    }


    @Override
    public String getSearchTerm() {
        return toString();
    }

    @Override
    public String getContentType() {
        return "ARTICLE";
    }
}



