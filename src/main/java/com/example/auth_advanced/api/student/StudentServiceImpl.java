package com.example.auth_advanced.api.student;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService{

    private final StudentRepository studentRepository;
    private final StudentAssembler studentAssembler;
    @Override
    public CollectionModel<?> findAllStudent() {
        List<Student> students = studentRepository.findAll();

        return studentAssembler.toCollectionModel(students);
    }

    @Override
    public EntityModel<?> findStudentByUuid(String uuid) {
        Student student = studentRepository.findByUuid(uuid).orElseThrow();
        return studentAssembler.toModel(student);
    }
}
