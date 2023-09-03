package com.example.auth_advanced.api.student;

import com.example.auth_advanced.api.student.web.StudentController;
import com.example.auth_advanced.api.student.web.StudentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.stereotype.Component;

@Component
public class StudentAssembler extends RepresentationModelAssemblerSupport<Student, EntityModel<StudentDto>> {
    @Autowired
    private StudentMapper studentMapper;

    public void setStudentMapper(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    @SuppressWarnings("unchecked")
    public StudentAssembler() {
        super(StudentController.class, (Class<EntityModel<StudentDto>>)(Class) EntityModel.class);
    }

    @Override
    public CollectionModel<EntityModel<StudentDto>> toCollectionModel(Iterable<? extends Student> entities) {
        return super.toCollectionModel(entities);
    }

    @Override
    public EntityModel<StudentDto> toModel(Student entity) {
        StudentDto studentDto = studentMapper.mapStudentToStudentDto(entity);

        Link selflink = linkTo(methodOn(StudentController.class).findStudent()).withSelfRel();
        Link collectionLink = linkTo(methodOn(StudentController.class).
                findStudentByUuid(entity.getUuid())).withRel(IanaLinkRelations.COLLECTION);

        return EntityModel.of(studentDto,selflink,collectionLink);
    }
}
