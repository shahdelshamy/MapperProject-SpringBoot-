package com.example.controller;

import com.example.dto.StudentDto;
import com.example.dto.StudentUpdate;
import com.example.model.Student;
import com.example.service.StudentService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/add")
    public ResponseEntity<Student> getStudent(@RequestBody Student s){
        return ResponseEntity.ok(studentService.insert(s));
    }

    @PutMapping("/update")
    public ResponseEntity<Student> getStudent(@RequestBody StudentUpdate s){
        return ResponseEntity.ok(studentService.update(s));
    }

    @GetMapping("/get")
    public ResponseEntity<StudentDto> getStudent(@RequestParam int id){
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

}
