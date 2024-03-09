package com.yunjisang.afterschool.afterschool.domain.Lecture.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.yunjisang.afterschool.afterschool.global.common.AbstractCodedEnumConverter;
import com.yunjisang.afterschool.afterschool.global.common.CodeEnum;

public enum Method implements CodeEnum<Integer> {
    ONLINE(100), OFFLINE(200), BOTH(300);

    private int code;

    Method(int code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    @jakarta.persistence.Converter(autoApply = true)
    static class Converter extends AbstractCodedEnumConverter<Method, Integer> {
        public Converter() {
            super(Method.class);
        }
    }

    @JsonCreator
    public static Method from(int input) {
        for (Method method : Method.values()) {
            if (method.getCode().equals(input)) {
                return method;
            }
        }
        return null;
    }
}
