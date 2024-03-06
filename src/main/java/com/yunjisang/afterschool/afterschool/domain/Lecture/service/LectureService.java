package com.yunjisang.afterschool.afterschool.domain.Lecture.service;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.yunjisang.afterschool.afterschool.domain.Lecture.domain.Lecture;
import com.yunjisang.afterschool.afterschool.domain.Lecture.repository.LectureRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LectureService {
    private final LectureRepository lectureRepository;

    public Lecture getLectureInfo(Long lectureId) {
        Lecture lecture = lectureRepository.findById(lectureId).orElseThrow();
        return lecture;
    }
}
