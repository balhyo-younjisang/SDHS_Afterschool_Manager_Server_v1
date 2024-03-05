package com.yunjisang.afterschool.afterschool.domain.Lecture.domain;

import com.yunjisang.afterschool.afterschool.global.common.AbstractCodedEnumConverter;
import com.yunjisang.afterschool.afterschool.global.common.CodeEnum;

public enum LectureDivision implements CodeEnum<Integer> {
    MAJOR(100), MUSIC(200), GENERAL_ELECTIVE(300), PE(400);

    private int code;

    LectureDivision(int code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    @jakarta.persistence.Converter(autoApply = true)
    static class Converter extends AbstractCodedEnumConverter<LectureDivision, Integer> {
        public Converter() {
            super(LectureDivision.class);
        }
    }
}
