package com.yunjisang.afterschool.afterschool.domain.Lecture.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yunjisang.afterschool.afterschool.domain.Lecture.dto.LectureRequestDTO.CreateLectureRequestDTO;
import com.yunjisang.afterschool.afterschool.domain.Lecture.dto.LectureRequestDTO.SearchLectureRequestDTO;
import com.yunjisang.afterschool.afterschool.domain.Lecture.dto.LectureResponseDTO.BaseLectureResponseDTO;
import com.yunjisang.afterschool.afterschool.domain.Lecture.service.LectureService;
import com.yunjisang.afterschool.afterschool.global.common.SuccessResponse;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.nio.charset.StandardCharsets;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class LectureControllerImpl implements LectureController {
    private final LectureService lectureService;

    @Override
    public ResponseEntity<SuccessResponse<BaseLectureResponseDTO>> postCreateLecture(
            @Valid @RequestBody CreateLectureRequestDTO createLectureRequestDTO) {
        SuccessResponse<BaseLectureResponseDTO> response = lectureService.save(createLectureRequestDTO);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));

        return new ResponseEntity<>(response, headers, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<SuccessResponse<List<BaseLectureResponseDTO>>> getLectureList(
            SearchLectureRequestDTO searchLectureRequestDTO) {
        SuccessResponse<List<BaseLectureResponseDTO>> response = lectureService.findLectures(searchLectureRequestDTO);
        return response;
    }

}
