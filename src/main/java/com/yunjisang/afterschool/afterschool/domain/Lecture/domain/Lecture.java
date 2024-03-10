package com.yunjisang.afterschool.afterschool.domain.Lecture.domain;

import java.time.LocalDateTime;

import com.yunjisang.afterschool.afterschool.domain.Lecture.dto.LectureResponseDTO.CreateLectureResponseDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author Yunjisnag
 * @since 2024.03.07
 * @version 1.0
 * @category Entity
 * @apiNote Lecture Entity
 */
@Entity
@Table(name = "lectures")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Lecture {
    @Id
    @Column(name = "lecture_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name; // 과목

    @Column(nullable = false)
    private String teacher; // 담당

    @Column(nullable = false)
    private LectureDivision division; // 분류

    @Column(nullable = false)
    private String lecture_room; // 수업장소

    @Column(nullable = false)
    private Long head_count; // 인원수

    @Column(nullable = false)
    private String target; // 대상

    @Column(nullable = false)
    private Method method; // 운영형태

    @Column(nullable = false)
    private String select_method; // 선별 방법

    @Column(nullable = false)
    private LocalDateTime start_date; // 방과후 시작 날짜

    @Column(nullable = false)
    private LocalDateTime end_date; // 방과후 종료 날짜

    @Column(nullable = false)
    private Day day; // 진행 요일

    @Column(nullable = false)
    private Long duration; // 일당 수업시간

    @Column(nullable = false)
    private Long all_hours; // 총 수업 시수

    @Column(nullable = false)
    private Long tuition; // 예상 수강료

    @Column(nullable = false)
    private String subsidy; // 지원금

    @Column(nullable = false)
    private String materials; // 준비물

    @Column(nullable = false)
    private String goals; // 수업 목표

    @Column(nullable = false)
    private String schedule; // 수업 일정

    @Column(nullable = false)
    @Builder.Default
    private boolean isDone = false; // 방과후 신청 기간이 끝났는지

    public boolean isDone() {
        return end_date.isBefore(LocalDateTime.now());
    }

    public CreateLectureResponseDTO toDTO() {
        return CreateLectureResponseDTO.builder().all_hours(this.all_hours).day(this.day).division(this.division)
                .duration(this.duration).end_date(this.end_date).goals(this.goals).head_count(this.head_count)
                .lectureName(this.name).lecture_room(this.lecture_room).materials(this.materials).method(this.method)
                .schedule(this.schedule).select_method(this.select_method).start_date(this.start_date)
                .subsidy(this.subsidy).target(this.target).teacher(this.teacher).tuition(this.tuition).build();
    }
}
