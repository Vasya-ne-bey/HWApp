package org.skypro.skyshop;

public interface Searchable {
    default String getStringRepresentation() {
        return getSearchTerm() + " - " + getContentType();

    }

    String getSearchTerm();

    String getContentType();
}
