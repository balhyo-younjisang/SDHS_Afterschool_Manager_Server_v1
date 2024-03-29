package com.yunjisang.afterschool.afterschool.domain.Lecture.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.yunjisang.afterschool.afterschool.global.common.AbstractCodedEnumConverter;
import com.yunjisang.afterschool.afterschool.global.common.CodeEnum;

public enum Day implements CodeEnum<Integer> {
    MON(1), TUE(2), WED(3), THU(4), FRI(5);

    private int code;

    Day(int code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    @jakarta.persistence.Converter(autoApply = true)
    static class Converter extends AbstractCodedEnumConverter<Day, Integer> {
        public Converter() {
            super(Day.class);
        }
    }

    @JsonCreator
    public static Day from(int input) {
        for (Day day : Day.values()) {
            if (day.getCode().equals(input)) {
                return day;
            }
        }
        return null;
    }
}
