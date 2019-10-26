package com.jalasoft.ocrwebservice.util;

import java.nio.file.Paths;

public class Constant {
    public static final String SRC_PATH = Paths.get("C:\\Users\\user.m1\\Documents\\GIT\\ocr-web-service\\public").toAbsolutePath().toString();
    public static final String RESOURCE_DIR = SRC_PATH;
    public static final String OUTPUT_FILE = "output.txt";
    public static final String OUTPUT_PATH = Paths.get("C:\\Users\\user.m1\\Documents\\GIT\\ocr-web-service\\public").toAbsolutePath().toString();
    public static final String TES4J_PATH="thirdParty/Tess4J/tessdata";
}
