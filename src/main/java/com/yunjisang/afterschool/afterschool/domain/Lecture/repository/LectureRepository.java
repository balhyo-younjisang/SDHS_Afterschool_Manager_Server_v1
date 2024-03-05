package com.yunjisang.afterschool.afterschool.domain.Lecture.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yunjisang.afterschool.afterschool.domain.Lecture.domain.Lecture;

@Repository
public interface LectureRepository extends JpaRepository<Lecture, Long> {

}
