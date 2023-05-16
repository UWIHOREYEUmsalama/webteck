package com.example.groupspring.service;



import com.example.groupspring.model.Student;

import java.util.List;

public interface StudentService {
    // method signature
    // return value , method name;
    Student registerStudent(Student stud);
    Student updateStudent(Student stud);
    void deleteStudent(String stud);
    List<Student> studentList();
    Student findStudentByStudentId(String stud);
}
