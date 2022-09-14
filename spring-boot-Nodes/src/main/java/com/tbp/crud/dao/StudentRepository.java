package com.tbp.crud.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tbp.crud.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
