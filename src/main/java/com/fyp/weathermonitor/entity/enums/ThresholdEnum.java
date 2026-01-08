package com.fyp.weathermonitor.entity.enums;

public enum ThresholdEnum {
    CODE_BELOW(0,"Below Threshold"),
    CODE_ABOVE(1,"Above Threshold"),
    CODE_NO_THRESHOLD(2,"No Comparison");


    private Integer code;
    private String name;

    ThresholdEnum(Integer code, String name){
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
