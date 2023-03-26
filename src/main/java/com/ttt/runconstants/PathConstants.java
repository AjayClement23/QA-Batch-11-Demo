package com.ttt.runconstants;

public final class PathConstants {

    private PathConstants(){

    }

    private static final String DIRECTORY_PATH = System.getProperty("user.dir");
    public static final String CONFIG_PROPERTY_FILE_PATH = DIRECTORY_PATH+"/src/main/resources/config.properties";
    public static final String EXCEL_TEST_DATA_FILE_PATH = DIRECTORY_PATH+"/src/test/Resources/TestData/DummyData.xlsx";

    public static final String EXTENT_TEST_RESULT_FILE_PATH = DIRECTORY_PATH+"/target/extent.html";
}
