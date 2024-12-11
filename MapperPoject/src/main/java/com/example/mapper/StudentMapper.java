package com.example.mapper;

import com.example.dto.StudentDto;
import com.example.dto.StudentUpdate;
import com.example.model.Student;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;


@Mapper(componentModel = "spring")   //to create bean for class
public interface StudentMapper {

    StudentDto mapToDto(Student s);

    //Student mapToEntity(StudentUpdate s);

    Student mapToUpdate(StudentUpdate dto ,@MappingTarget Student s);

}
