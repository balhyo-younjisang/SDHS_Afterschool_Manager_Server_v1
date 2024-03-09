package com.yunjisang.afterschool.afterschool.domain.Lecture.service;

import java.time.LocalDateTime;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import com.yunjisang.afterschool.afterschool.domain.Lecture.domain.Day;
import com.yunjisang.afterschool.afterschool.domain.Lecture.domain.Lecture;
import com.yunjisang.afterschool.afterschool.domain.Lecture.domain.LectureDivision;
import com.yunjisang.afterschool.afterschool.domain.Lecture.domain.Method;
import com.yunjisang.afterschool.afterschool.domain.Lecture.dto.LectureRequestDTO;
import com.yunjisang.afterschool.afterschool.domain.Lecture.repository.LectureRepository;

@ExtendWith(MockitoExtension.class)
public class LectureServiceTest {
    @InjectMocks
    private LectureService lectureService;

    @Mock
    private LectureRepository lectureRepository;

    @DisplayName("강의 생성 테스트")
    @Test
    public void 강의_생성() throws Exception {
        // given
        LectureRequestDTO.CreateLectureRequestDTO createLecture = createCreateLectureRequestDTO();
        Lecture lecture = createLectureEntity(createLecture);

        Long fakeLectureId = 1L;
        ReflectionTestUtils.setField(lecture, "id", fakeLectureId);

        lectureRepository.save(lecture);
    }

    private LectureRequestDTO.CreateLectureRequestDTO createCreateLectureRequestDTO() {
        LectureRequestDTO.CreateLectureRequestDTO createCreateLectureRequestDTO = new LectureRequestDTO.CreateLectureRequestDTO();
        LocalDateTime startDate = LocalDateTime.now();
        LocalDateTime endDate = startDate.plusDays(10);

        createCreateLectureRequestDTO.setTeacher("윤지상");
        createCreateLectureRequestDTO.setLectureName("윤지상의 인생 강의");
        createCreateLectureRequestDTO.setDay(Day.MON);
        createCreateLectureRequestDTO.setAll_hours(30L);
        createCreateLectureRequestDTO.setDivision(LectureDivision.MAJOR);
        createCreateLectureRequestDTO.setDuration(3L);
        createCreateLectureRequestDTO.setGoals("인생 제대로 살기");
        createCreateLectureRequestDTO.setMethod(Method.OFFLINE);
        createCreateLectureRequestDTO.setSchedule("4주 동안 진행");
        createCreateLectureRequestDTO.setMaterials("필기구");
        createCreateLectureRequestDTO.setLectureName("209");
        createCreateLectureRequestDTO.setSelect_method("전공 우선");
        createCreateLectureRequestDTO.setSubsidy("국가지원금");
        createCreateLectureRequestDTO.setHead_count(14L);
        createCreateLectureRequestDTO.setTuition(0L);
        createCreateLectureRequestDTO.setTarget("전공생");
        createCreateLectureRequestDTO.setStart_date(startDate);
        createCreateLectureRequestDTO.setEnd_date(endDate);

        return createCreateLectureRequestDTO;
    }

    private Lecture createLectureEntity(LectureRequestDTO.CreateLectureRequestDTO lecture) {
        return Lecture.builder().name(lecture.getLectureName()).teacher(lecture.getTeacher())
                .all_hours(lecture.getAll_hours()).day(lecture.getDay()).lecture_room(lecture.getLecture_room())
                .division(lecture.getDivision()).duration(lecture.getDuration()).goals(lecture.getGoals())
                .head_count(lecture.getHead_count()).start_date(lecture.getStart_date()).end_date(lecture.getEnd_date())
                .materials(lecture.getMaterials()).method(lecture.getMethod()).schedule(lecture.getSchedule())
                .select_method(lecture.getSelect_method()).start_date(lecture.getStart_date())
                .end_date(lecture.getEnd_date()).target(lecture.getTarget()).build();
    }
}
