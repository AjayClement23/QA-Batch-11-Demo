package com.ttt.enums;

public enum TestDataColumnHeaders {


    TESTCASENAME("TestCaseName");

    private String header;

    TestDataColumnHeaders(String header){
       this.header = header;
   }

    public String getHeader() {
        return header;
    }
}
