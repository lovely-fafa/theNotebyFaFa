package com.itheima.enums;

import com.baomidou.mybatisplus.annotation.IEnum;

public enum SexEnum implements IEnum<Integer> {
    MAN(1, "男"),
    WOMAN(2, "女");

    private int values;
    private String desc;

    SexEnum(int values, String desc) {
        this.values = values;
        this.desc = desc;
    }

    @Override
    public Integer getValue() {
        return values;
    }

    @Override
    public String toString() {
        return desc;
    }
}
