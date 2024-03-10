package com.yunjisang.afterschool.afterschool.domain.Lecture.dto;

import com.yunjisang.afterschool.afterschool.domain.Lecture.domain.Day;
import com.yunjisang.afterschool.afterschool.domain.Lecture.domain.LectureDivision;
import com.yunjisang.afterschool.afterschool.domain.Lecture.domain.Method;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class LectureResponseDTO {

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CreateLectureResponseDTO {
        private String lectureName; // 강의 이름
        private String teacher; // 담당
        private LectureDivision division; // 분류
        private String lecture_room; // 수업장소
        private Long head_count; // 인원수
        private String target; // 대상
        private Method method; // 운영형태
        private String select_method; // 선별 방법
        private LocalDateTime start_date; // 방과후 시작 날짜
        private LocalDateTime end_date; // 방과후 종료 날짜
        private Day day; // 진행 요일
        private Long duration; // 일당 수업시간
        private Long all_hours; // 총 수업 시수
        private Long tuition; // 예상 수강료
        private String subsidy; // 지원금
        private String materials; // 준비물
        private String goals; // 수업 목표
        private String schedule; // 수업 일정
    }
}
