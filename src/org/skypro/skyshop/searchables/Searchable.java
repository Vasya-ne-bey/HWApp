package org.skypro.skyshop.searchables;

public interface Searchable {
    default String getStringRepresentation() {
        return getSearchTerm() + " - " + getContentType();

    }

    String getSearchTerm();

    String getContentType();
}
