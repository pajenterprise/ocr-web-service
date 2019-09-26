package com.jalasoft.ocrwebservice.util;

public enum Language {
    EN("en"),
    ES("es");

    private String abbreviation;

    public String getAbbreviation() {
        return this.abbreviation;
    }

    Language(String abbreviation) {
        this.abbreviation = abbreviation;
    }
}
