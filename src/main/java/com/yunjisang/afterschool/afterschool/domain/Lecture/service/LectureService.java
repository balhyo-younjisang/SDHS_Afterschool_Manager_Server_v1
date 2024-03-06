package com.yunjisang.afterschool.afterschool.domain.Lecture.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.yunjisang.afterschool.afterschool.domain.Lecture.domain.Lecture;
import com.yunjisang.afterschool.afterschool.domain.Lecture.repository.LectureRepository;
import com.yunjisang.afterschool.afterschool.global.exception.CustomException;
import com.yunjisang.afterschool.afterschool.global.exception.ErrorCode;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LectureService {
    private final LectureRepository lectureRepository;

    public Lecture getLectureInfo(Long lectureId) {
        Lecture lecture = lectureRepository.findById(lectureId)
                .orElseThrow(() -> new CustomException(ErrorCode.LECTURE_NOT_FOUND));
        return lecture;
    }

    public void save(Lecture lecture) {
        Optional<Lecture> alreadyLecture = lectureRepository.findByName(lecture.getName());

        if (alreadyLecture.isPresent() && alreadyLecture.get().isDone()) {
            throw new CustomException(ErrorCode.LECTURE_DUPLICATE);
        }
        lectureRepository.save(lecture);
    }

    public List<Lecture> findLectureByTeacher(String teacher) {
        List<Lecture> lectures = lectureRepository.findAllByTeacher(teacher)
                .orElseThrow(() -> new CustomException(ErrorCode.TEACHER_NOT_FOUND));
        return lectures;
    }
}
