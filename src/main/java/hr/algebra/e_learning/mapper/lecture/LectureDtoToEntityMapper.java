package hr.algebra.e_learning.mapper.lecture;

import hr.algebra.e_learning.dto.LectureDTO;
import hr.algebra.e_learning.entity.Lecture;
import hr.algebra.e_learning.mapper.Mapper;
import org.springframework.stereotype.Component;

@Component
public class LectureDtoToEntityMapper implements Mapper<LectureDTO, Lecture> {

    @Override
    public Lecture convert(LectureDTO dto) {
        return Lecture.builder()
                .id(dto.id())
                .title(dto.title())
                .description(dto.description())
                .build();
    }
}
