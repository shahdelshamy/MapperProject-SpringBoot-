package com.example.service;

import com.example.dto.StudentDto;
import com.example.dto.StudentUpdate;
import com.example.mapper.StudentMapper;
import com.example.model.Student;
import com.example.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class StudentService {

    @Autowired
    private  StudentRepo studentRepo;

    @Autowired
    private StudentMapper studentMapper;

    public Student insert(Student student){
        return studentRepo.save(student);
    }

    public Student update(StudentUpdate s) {
        Optional<Student> oldStudent= studentRepo.findById(s.getId());
        if(oldStudent.isPresent()){
            /*
            Student newStudent=new Student();

            newStudent.setId(s.getId());
            newStudent.setName(s.getName());
            newStudent.setAga(s.getAge());

            newStudent.setGender(oldStudent.get().getGender());
            newStudent.setScore(oldStudent.get().getScore());

            return studentRepo.save(newStudent);
             */

            return studentRepo.save(studentMapper.mapToUpdate(s,oldStudent.get()));

        }else{
            throw new RuntimeException("This Studenet Not Exist");
        }


    }

    public StudentDto getStudentById(int id){
        return studentMapper.mapToDto(studentRepo.findById(id).orElseThrow(()->new RuntimeException("This Student Not Found")))  ;
    }


}
