package com.ignore;

public enum TestEnum {

    TEST_1(1,"测试1"),
    TEST_2(2,"测试2"),
    TEST_3(3,"测试3");

    private Integer code;

    private String value;

    private TestEnum(Integer code,String value){
        this.code = code;
        this.value = value;
    }

    public Integer getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }
}
