package com.yunjisang.afterschool.afterschool.domain.Lecture.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yunjisang.afterschool.afterschool.domain.Lecture.dto.LectureRequestDTO;
import com.yunjisang.afterschool.afterschool.domain.Lecture.dto.LectureResponseDTO;
import com.yunjisang.afterschool.afterschool.global.common.SuccessResponse;

import jakarta.validation.Valid;

@RequestMapping(value = "/api/v1/lecture")
public interface LectureController {
    /**
     * Lecture를 생성하고 DB에 저장
     * 
     * @param createLectureRequestDTO
     * @return Void
     */
    @PostMapping(value = "/create")
    public ResponseEntity<SuccessResponse<LectureResponseDTO.CreateLectureResponseDTO>> postCreateLecture(
            @Valid @RequestBody LectureRequestDTO.CreateLectureRequestDTO createLectureRequestDTO);

}