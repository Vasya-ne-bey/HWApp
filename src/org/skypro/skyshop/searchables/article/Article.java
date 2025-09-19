package org.skypro.skyshop.searchables.article;

import org.skypro.skyshop.searchables.Searchable;

import java.util.Objects;

public final class Article implements Searchable {
    private String articleName;
    private String articleContent;

    public Article(String articleContent, String articleName) {
        this.articleContent = articleContent;
        this.articleName = articleName;
    }

    @Override
    public String toString() {
        return articleName + " " + articleContent + "\n";

    }

    public String getArticleName() {
        return articleName;
    }

    @Override
    public String getSearchTerm() {
        return toString();
    }

    @Override
    public String getContentType() {
        return "ARTICLE";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(articleName, article.articleName);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(articleName);
    }
}



