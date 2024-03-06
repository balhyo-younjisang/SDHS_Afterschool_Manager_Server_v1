package com.yunjisang.afterschool.afterschool.domain.Lecture.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yunjisang.afterschool.afterschool.domain.Lecture.domain.Lecture;
import com.yunjisang.afterschool.afterschool.domain.Lecture.domain.LectureDivision;

@Repository
public interface LectureRepository extends JpaRepository<Lecture, Long> {
    Optional<Lecture> findByName(String name);

    Optional<Page<Lecture>> findAllByTeacher(String teacher, Pageable pa);

    Page<Lecture> findAllByNameContaining(String keyword, Pageable pageable);

    Page<Lecture> findAllByDivision(LectureDivision lectureDivision, Pageable pageable);
}
