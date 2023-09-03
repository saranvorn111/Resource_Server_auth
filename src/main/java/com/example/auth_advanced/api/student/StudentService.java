package com.example.auth_advanced.api.student;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;

public interface StudentService {
    CollectionModel<?> findAllStudent();

    EntityModel<?> findStudentByUuid(String uuid);
}
