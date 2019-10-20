package com.jalasoft.ocrwebservice.util;

import java.nio.file.Paths;

public class Constant {
    public static final String SRC_PATH = Paths.get("public").toAbsolutePath().toString();
    public static final String RESOURCE_DIR = SRC_PATH;
    public static final String NOTFOUND = "404" ;
    public static final String BADREQUEST = "400";
    public static final String OK = "200";
}
