package com.jalasoft.ocrwebservice.util;

public enum ImageType {
    JPG("jpg"),
    PNG("png"),
    TIF("tif"),
    BMP("bmp");

    private String extension;

    public String getExtension() {
        return this.extension;
    }

    ImageType(String abbreviation) {
        this.extension = abbreviation;
    }
}
