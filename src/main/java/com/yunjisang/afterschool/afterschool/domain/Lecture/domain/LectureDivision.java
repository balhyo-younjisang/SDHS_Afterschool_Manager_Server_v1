package com.yunjisang.afterschool.afterschool.domain.Lecture.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.yunjisang.afterschool.afterschool.global.common.AbstractCodedEnumConverter;
import com.yunjisang.afterschool.afterschool.global.common.CodeEnum;

public enum LectureDivision implements CodeEnum<Integer> {
    MAJOR(100), MUSIC(200), GENERAL_ELECTIVE(300), PE(400);

    private int code;

    LectureDivision(int code) {
        this.code = code;
    }

    @JsonValue
    public Integer getCode() {
        return code;
    }

    @jakarta.persistence.Converter(autoApply = true)
    static class Converter extends AbstractCodedEnumConverter<LectureDivision, Integer> {
        public Converter() {
            super(LectureDivision.class);
        }
    }

    @JsonCreator
    public static LectureDivision from(int input) {
        for (LectureDivision lectureDivision : LectureDivision.values()) {
            if (lectureDivision.getCode().equals(input)) {
                return lectureDivision;
            }
        }
        return null;
    }
}
