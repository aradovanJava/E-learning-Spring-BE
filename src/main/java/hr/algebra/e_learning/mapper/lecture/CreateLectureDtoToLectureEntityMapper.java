package hr.algebra.e_learning.mapper.lecture;

import hr.algebra.e_learning.dto.lecture.CreateLectureDTO;
import hr.algebra.e_learning.entity.Lecture;
import hr.algebra.e_learning.mapper.Mapper;
import org.springframework.stereotype.Component;

@Component
public class CreateLectureDtoToLectureEntityMapper implements Mapper<CreateLectureDTO, Lecture> {

    @Override
    public Lecture convert(final CreateLectureDTO dto) {
        return Lecture.builder()
                .title(dto.getTitle())
                .description(dto.getDescription())
                .build();
    }
}
