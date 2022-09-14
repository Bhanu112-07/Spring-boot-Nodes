package com.tbp.crud.controller;

import java.util.List;

import com.tbp.crud.entity.Student;
import com.tbp.crud.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping(value="addStudent",method = RequestMethod.POST)
    public Student addStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    //@PostMapping("/addUsers")
    //public List<User> addUsers(@RequestBody List<User> users) {
    //return userService.createUsers(users);
    //}

    @GetMapping("/student/{id}")
    public Student getStudentById(@PathVariable int id) {
        return studentService.getStudentById(id);
    }

    @GetMapping("/student")
    public List<Student> getAllStudent() {
        return studentService.getStudent();
    }

    @PutMapping("/updateStudent/{id}")
    public Student updateStudent(@RequestBody Student student,@PathVariable String id) {
        return studentService.updateStudent(student);
    }

    @DeleteMapping("/student/{id}")
    public String deleteStudent(@PathVariable int id) {
        return studentService.deleteStudentById(id);
    }
}