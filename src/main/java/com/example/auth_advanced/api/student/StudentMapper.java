package com.example.auth_advanced.api.student;

import com.example.auth_advanced.api.student.web.StudentDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    StudentDto mapStudentToStudentDto(Student student);
}
