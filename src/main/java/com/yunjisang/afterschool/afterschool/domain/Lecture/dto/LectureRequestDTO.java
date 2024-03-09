package com.yunjisang.afterschool.afterschool.domain.Lecture.dto;

import com.yunjisang.afterschool.afterschool.domain.Lecture.domain.Day;
import com.yunjisang.afterschool.afterschool.domain.Lecture.domain.LectureDivision;
import com.yunjisang.afterschool.afterschool.domain.Lecture.domain.Method;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class LectureRequestDTO {
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CreateLectureRequestDTO {
        @NotBlank(message = "강의 이름 항목은 필수 입력 항목입니다.")
        private String lectureName; // 강의 이름

        @NotBlank(message = "담당 선생님 성함 항목은 필수로 입력해주세요.")
        private String teacher; // 담당

        @NotNull(message = "강의 분류 항목은 필수 입력 항목입니다.")
        private LectureDivision division; // 분류

        @NotBlank(message = "수업 장소 항목은 필수 입력 항목입니다.")
        private String lecture_room; // 수업장소

        @NotBlank(message = "최대 수강 인원 수 항목은 필수 입력 항목입니다.")
        private Long head_count; // 인원수

        @NotBlank(message = "수강 대상 항목은 필수 입력 항목입니다.")
        private String target; // 대상

        @NotNull(message = "운영 방식 항목은 필수 입력 항목입니다.")
        private Method method; // 운영형태

        @NotBlank(message = "선별 방법 항목은 필수 입력 항목입니다.")
        private String select_method; // 선별 방법

        @NotBlank(message = "시작 날짜 항목은 필수 입력 항목입니다.")
        private LocalDateTime start_date; // 방과후 시작 날짜

        @NotBlank(message = "종료 날짜 항목은 필수 입력 항목입니다.")
        private LocalDateTime end_date; // 방과후 종료 날짜

        @NotBlank(message = "진행 요일 항목은 필수 입력 항목입니다.")
        private Day day; // 진행 요일

        @NotBlank(message = "수업 시간 항목은 필수 입력 항목입니다.")
        private Long duration; // 일당 수업시간

        @NotBlank(message = "총 수업 시수 항목은 필수 입력 항목입니다.")
        private Long all_hours; // 총 수업 시수

        @NotBlank(message = "예상 수강료 항목은 필수 입력 항목입니다.")
        private Long tuition; // 예상 수강료

        @NotBlank(message = "지원금 항목은 필수 입력 항목입니다.")
        private String subsidy; // 지원금

        @NotBlank(message = "준비물 항목은 필수 입력 항목입니다.")
        private String materials; // 준비물

        @NotBlank(message = "수업 목표 항목은 필수 입력 항목입니다.")
        private String goals; // 수업 목표

        @NotBlank(message = "수업 일정 항목은 필수 입력 항목입니다.")
        private String schedule; // 수업 일정
    }
}
