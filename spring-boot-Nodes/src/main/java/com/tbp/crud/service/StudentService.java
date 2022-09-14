package com.tbp.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tbp.crud.dao.StudentRepository;
import com.tbp.crud.entity.Student;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> createStudent(List<Student> students) {
        return studentRepository.saveAll(students);
    }

    public Student getStudentById(int id) {
        return studentRepository.findById(id).orElse(null);
    }

    public List<Student> getStudent() {
        return studentRepository.findAll();
    }

    public Student updateStudent(Student student) {
        Student oldStudent=null;
        Optional<Student> optionalstudent=studentRepository.findById(student.getId());
        if(optionalstudent.isPresent()) {
            oldStudent=optionalstudent.get();
            oldStudent.setName(student.getName());
            oldStudent.setEmail(oldStudent.getEmail());
            oldStudent.setRole(oldStudent.getRole());
            studentRepository.save(oldStudent);
        }else {
            return new Student();

        }
        return oldStudent;
    }

    public String deleteStudentById(int id) {
        studentRepository.deleteById(id);
        return "Student got deleted";
    }

}
