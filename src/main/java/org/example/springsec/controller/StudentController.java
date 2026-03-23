package org.example.springsec.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.example.springsec.entities.Student;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    private  List<Student> students = new ArrayList<>(List.of(
            new Student(1, "ram", 40),
            new Student(2, "shyam", 30),
            new Student(3, "ayush", 50)
    ));
    @GetMapping("/students")
    public List<Student> getStudents(){
    return  students;
    }
    @GetMapping("/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }
    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student){
        students.add(student);
        return student;
    }
}
