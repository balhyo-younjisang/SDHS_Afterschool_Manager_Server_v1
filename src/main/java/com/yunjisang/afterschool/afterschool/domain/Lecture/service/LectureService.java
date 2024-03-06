package com.yunjisang.afterschool.afterschool.domain.Lecture.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.yunjisang.afterschool.afterschool.domain.Lecture.domain.Lecture;
import com.yunjisang.afterschool.afterschool.domain.Lecture.domain.LectureDivision;
import com.yunjisang.afterschool.afterschool.domain.Lecture.repository.LectureRepository;
import com.yunjisang.afterschool.afterschool.global.exception.CustomException;
import com.yunjisang.afterschool.afterschool.global.exception.ErrorCode;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LectureService {
    private final LectureRepository lectureRepository;

    /**
     * Lecture Entity 를 리턴
     * 
     * @param lectureId
     * @return Lecture
     */
    public Lecture getLectureInfo(Long lectureId) {
        Lecture lecture = lectureRepository.findById(lectureId)
                .orElseThrow(() -> new CustomException(ErrorCode.LECTURE_NOT_FOUND));
        return lecture;
    }

    /**
     * 인자로 들어온 Entity를 Database에 저장
     * 
     * @param lecture
     */
    public void save(Lecture lecture) {
        Optional<Lecture> alreadyLecture = lectureRepository.findByName(lecture.getName());

        if (alreadyLecture.isPresent() && alreadyLecture.get().isDone()) {
            throw new CustomException(ErrorCode.LECTURE_DUPLICATE);
        }
        lectureRepository.save(lecture);
    }

    /**
     * 인자로 받은 teacher 값을 Database에서 찾아 Paging을 통해 리턴
     * 
     * @param teacher
     * @param pageable
     * @return Page<Lecture>
     */
    public Page<Lecture> findLecturesByTeacher(String teacher, Pageable pageable) {
        Page<Lecture> lectures = lectureRepository.findAllByTeacher(teacher, pageable)
                .orElseThrow(() -> new CustomException(ErrorCode.TEACHER_NOT_FOUND));
        return lectures;
    }

    /**
     * 인자로 받은 검색어를 통해 Database에서 검색 후 Paging 처리를 해 반환
     * 
     * @param keywords
     * @param pageable
     * @return Page<Lecture>
     */
    public Page<Lecture> searchLecture(String keywords, Pageable pageable) {
        return lectureRepository.findAllByNameContaining(keywords, pageable);
    }

    /**
     * 강의 분류를 통해 강의를 찾아 반환
     * 
     * @param lectureDivision
     * @param pageable
     * @return
     */
    public Page<Lecture> findLecturesByDivision(LectureDivision lectureDivision, Pageable pageable) {
        return lectureRepository.findAllByDivision(lectureDivision, pageable);
    }
}
