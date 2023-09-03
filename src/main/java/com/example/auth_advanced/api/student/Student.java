package com.example.auth_advanced.api.student;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.id.IncrementGenerator;
import org.springframework.web.bind.annotation.GetMapping;

@Entity
@Table(name = "students")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String uuid;
    private String name;
    private String gender;
}
