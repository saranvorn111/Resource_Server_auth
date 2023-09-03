package com.example.auth_advanced.api.init;

import com.example.auth_advanced.api.student.Student;
import com.example.auth_advanced.api.student.StudentRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class DataInit {
    private final StudentRepository studentRepository;

    @PostConstruct
    void init(){
        System.out.println("Hello world");

        Student student1 = Student.builder()
                .uuid(UUID.randomUUID().toString())
                .name("saran")
                .gender("Male")
                .build();

        Student student2 = Student.builder()
                .uuid(UUID.randomUUID().toString())
                .name("sophea")
                .gender("Male")
                .build();

        Student student3 = Student.builder()
                .uuid(UUID.randomUUID().toString())
                .name("seyPhea")
                .gender("female")
                .build();

        studentRepository.saveAll(List.of(student1,student2,student3));
        List<Student> students = studentRepository.findAll();
        students.forEach(student-> System.out.println(student.getName()));

    }

}
