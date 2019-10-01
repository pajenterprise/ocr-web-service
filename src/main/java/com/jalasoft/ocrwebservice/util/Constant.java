package com.jalasoft.ocrwebservice.util;

import java.nio.file.Paths;

public class Constant {
    public static final String SRC_PATH = Paths.get("src").toAbsolutePath().toString();
    public static final String RESOURCE_DIR = SRC_PATH.concat("/main/resources/");
}
