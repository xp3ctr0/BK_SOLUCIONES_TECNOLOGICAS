package com.backend.soluciones.tecnologicas.rest;

import com.backend.soluciones.tecnologicas.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class studentRestController {

    private List<Student> students;

    @PostConstruct()
    public void loadData() {
        students = new ArrayList<>();
        students.add(new Student("Jhon","Gonzalez"));
        students.add(new Student("Patricia","Cortes"));
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }

//    @GetMapping("/students/{studentId}")
//    public Student getStudent();

}
