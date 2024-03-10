package com.yunjisang.afterschool.afterschool.domain.Lecture.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.yunjisang.afterschool.afterschool.domain.Lecture.domain.Lecture;
import com.yunjisang.afterschool.afterschool.domain.Lecture.domain.LectureDivision;
import com.yunjisang.afterschool.afterschool.domain.Lecture.dto.LectureRequestDTO.CreateLectureRequestDTO;
import com.yunjisang.afterschool.afterschool.domain.Lecture.dto.LectureResponseDTO.CreateLectureResponseDTO;
import com.yunjisang.afterschool.afterschool.domain.Lecture.repository.LectureRepository;
import com.yunjisang.afterschool.afterschool.global.common.SuccessResponse;
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
    public SuccessResponse<CreateLectureResponseDTO> save(CreateLectureRequestDTO createLectureRequestDTO) {
        Assert.notNull(createLectureRequestDTO.getAll_hours(), "총 수업 시수 항목은 필수 입력 항목입니다.");
        Assert.notNull(createLectureRequestDTO.getDuration(), "수업 시간 항목은 필수 입력 항목입니다.");
        Assert.hasLength(createLectureRequestDTO.getGoals(), "수업 목표 항목은 필수 입력 항목입니다.");
        Assert.notNull(createLectureRequestDTO.getHead_count(), "최대 수강 인원 수 항목은 필수 입력 항목입니다.");
        Assert.hasLength(createLectureRequestDTO.getLectureName(), "강의 이름 항목은 필수 입력 항목입니다.");
        Assert.hasLength(createLectureRequestDTO.getLecture_room(), "수업 장소 항목은 필수 입력 항목입니다.");
        Assert.hasLength(createLectureRequestDTO.getMaterials(), "준비물 항목은 필수 입력 항목입니다.");
        Assert.hasLength(createLectureRequestDTO.getSchedule(), "수업 일정 항목은 필수 입력 항목입니다.");
        Assert.hasLength(createLectureRequestDTO.getSelect_method(), "선별 방법 항목은 필수 입력 항목입니다.");
        Assert.hasLength(createLectureRequestDTO.getSubsidy(), "지원금 항목은 필수 입력 항목입니다.");
        Assert.hasLength(createLectureRequestDTO.getTarget(), "운영 방식 항목은 필수 입력 항목입니다.");
        Assert.hasLength(createLectureRequestDTO.getTeacher(), "담당 선생님 성함 항목은 필수로 입력해주세요.");
        Assert.notNull(createLectureRequestDTO.getTuition(), "예상 수강료 항목은 필수 입력 항목입니다.");
        Assert.notNull(createLectureRequestDTO.getDay(), "진행 요일 항목은 필수 입력 항목입니다.");
        Assert.notNull(createLectureRequestDTO.getDivision(), "강의 분류 항목은 필수 입력 항목입니다.");
        Assert.notNull(createLectureRequestDTO.getEnd_date(), "종료 날짜 항목은 필수 입력 항목입니다.");
        Assert.notNull(createLectureRequestDTO.getMethod(), "운영 방식 항목은 필수 입력 항목입니다.");
        Assert.notNull(createLectureRequestDTO.getStart_date(), "시작 날짜 항목은 필수 입력 항목입니다.");

        Lecture lecture = Lecture.builder().all_hours(createLectureRequestDTO.getAll_hours())
                .day(createLectureRequestDTO.getDay()).division(createLectureRequestDTO.getDivision())
                .duration(createLectureRequestDTO.getDuration()).end_date(createLectureRequestDTO.getEnd_date())
                .goals(createLectureRequestDTO.getGoals()).head_count(createLectureRequestDTO.getHead_count())
                .lecture_room(createLectureRequestDTO.getLecture_room())
                .materials(createLectureRequestDTO.getMaterials()).method(createLectureRequestDTO.getMethod())
                .name(createLectureRequestDTO.getLectureName()).schedule(createLectureRequestDTO.getSchedule())
                .select_method(createLectureRequestDTO.getSelect_method())
                .start_date(createLectureRequestDTO.getStart_date()).subsidy(createLectureRequestDTO.getSubsidy())
                .target(createLectureRequestDTO.getTarget()).teacher(createLectureRequestDTO.getTeacher())
                .tuition(createLectureRequestDTO.getTuition()).build();

        Optional<Lecture> alreadyLecture = lectureRepository.findByName(lecture.getName());

        // 기존 등록된 강의가 끝나지 않은 상태라면 LECTURE_DUPLICATE 에러 처리
        if (alreadyLecture.isPresent() && !alreadyLecture.get().isDone()) {
            throw new CustomException(ErrorCode.LECTURE_DUPLICATE);
        }
        Lecture createdLecture = lectureRepository.save(lecture);
        CreateLectureResponseDTO responseLecture = createdLecture.toDTO();

        return new SuccessResponse<CreateLectureResponseDTO>(true, responseLecture);
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
