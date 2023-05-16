package com.example.groupspring.service.implementation;
import com.example.groupspring.model.Student;
import com.example.groupspring.repository.StudentRepository;
import com.example.groupspring.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public Student registerStudent(Student stud) {
        return studentRepository.save(stud);
    }

    @Override
    public Student updateStudent(Student stud) {
      return studentRepository.save(stud);
    }

    @Override
    public void deleteStudent(String stud) {
        studentRepository.deleteById(stud);
    }


    @Override
    public List<Student> studentList() {
        return studentRepository.findAll();
    }

    @Override
    public Student findStudentByStudentId(String stud) {
        return studentRepository.findById(stud).get();
    }
}
