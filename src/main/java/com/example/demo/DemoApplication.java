
package com.example.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.demo.dao.StudentDao;
import com.example.demo.entites.Student;

public class DemoApplication {
    public static void main(String[] args) {
     ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
     StudentDao studentDao = context.getBean("studentDao",  StudentDao.class);
     Student student = new Student();
     student.setId(1);
     student.setName("Rahul");
     student.setCity("surat");
     studentDao.insert(student);
     System.out.println("student added");

     student.setId(1);
     student.setName("keval");
     student.setCity("surat");
     studentDao.update(student);
     System.out.println("student update");

     //delete record
     studentDao.delete(1);
     System.out.println("student delete");

     Student students = studentDao.select(1);
     System.out.println("student select" + students);

     //selete multiple record
     List<Student> studentsList = studentDao.selectAll();
     System.out.println("student select" + studentsList);
    }
    }


