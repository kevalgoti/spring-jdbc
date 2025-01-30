package com.example.demo.dao;

import java.util.List;

import com.example.demo.entites.Student;

public interface StudentDao {

    //insert record
    public int insert(Student student);

    //update record
    public int update(Student student);

    //delete record
    public int delete(int id);

    //selete single data
    public Student select(int id);

    //selete multiple data
    public List<Student> selectAll();
}
