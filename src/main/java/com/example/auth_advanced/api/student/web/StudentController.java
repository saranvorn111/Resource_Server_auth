package com.example.auth_advanced.api.student.web;

import com.example.auth_advanced.api.student.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping
    public CollectionModel<?> findStudent(){
        return studentService.findAllStudent();

    }
    @GetMapping("{uuid}")
    public EntityModel<?> findStudentByUuid(@PathVariable String uuid){
      return studentService.findStudentByUuid(uuid);

    }
}
