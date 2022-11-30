package com.celean.students.controllers;

import com.celean.students.dto.StudentDto;
import com.celean.students.entityes.Student;
import com.celean.students.exceptions.ResourceNotFoundException;
import com.celean.students.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping(value = "/students")
    public Page<StudentDto> findAll(@RequestParam(name = "p", defaultValue = "1") int pageIndex) {
        if (pageIndex < 1) {
            pageIndex = 1;
        }
        return studentService.findAll(pageIndex - 1, 10).map(StudentDto::new);
    }

    @GetMapping("/student/{id}")
    public StudentDto findById(@PathVariable Long id){
        return new StudentDto(studentService
                .findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Student id = "+ id +" not found")));
    }

    @DeleteMapping("/students/delete/{id}")
    public void deleteStudentById (@PathVariable Long id){
        studentService.deleteStudentById(id);
    }

    @PostMapping("/students")
    @ResponseStatus(HttpStatus.CREATED)
    public StudentDto save(@RequestBody StudentDto studentDto){
        Student student = new Student();
        student.setId(studentDto.getId());
        student.setName(studentDto.getName());
        student.setAge(studentDto.getAge());
        studentService.save(student);
        return new StudentDto(student);
    }







}
