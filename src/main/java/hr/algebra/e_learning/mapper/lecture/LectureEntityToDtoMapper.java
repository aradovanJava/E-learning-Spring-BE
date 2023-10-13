package hr.algebra.e_learning.mapper.lecture;

import hr.algebra.e_learning.dto.lecture.LectureDTO;
import hr.algebra.e_learning.entity.Lecture;
import hr.algebra.e_learning.mapper.Mapper;
import org.springframework.stereotype.Component;

@Component
public class LectureEntityToDtoMapper implements Mapper<Lecture, LectureDTO> {

    @Override
    public LectureDTO convert(Lecture entity) {
        return LectureDTO.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .description(entity.getDescription())
                .courseId(entity.getCourse().getId())
                .build();
    }
}
