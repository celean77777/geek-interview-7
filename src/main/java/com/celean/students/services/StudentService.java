package com.celean.students.services;

import com.celean.students.entityes.Student;
import com.celean.students.repositories.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public Page<Student> findAll(int pageIndex, int pageSize){
        return studentRepository.findAll(PageRequest.of(pageIndex, pageSize));
    }

    public Optional<Student> findById(Long id){
        return studentRepository.findById(id);
    }

    public Student save(Student student){
        return studentRepository.save(student);
    }


    public void deleteStudentById (Long id){
        studentRepository.deleteById(id);
    }

}
