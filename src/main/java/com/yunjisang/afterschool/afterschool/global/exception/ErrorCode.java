package com.yunjisang.afterschool.afterschool.global.exception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    LECTURE_NOT_FOUND(HttpStatus.NOT_FOUND, "LECTURE_001", "강의를 찾을 수 없습니다"),
    LECTURE_DUPLICATE(HttpStatus.OK, "LECTURE_002", "이미 등록된 강의입니다"),
    TEACHER_NOT_FOUND(HttpStatus.NOT_FOUND, "LECTURE_003", "선생님을 찾을 수 없습니다");

    private final HttpStatus httpStatus; // HttpStatus
    private final String code; // 에러 코드
    private String message; // 메시지
}
