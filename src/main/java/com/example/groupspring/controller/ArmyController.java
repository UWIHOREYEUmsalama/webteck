package com.example.groupspring.controller;

import com.example.groupspring.model.Student;
import com.example.groupspring.service.implementation.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

// import java.util.List;

@Controller
public class StudentController {

    @Autowired
    StudentServiceImpl studentService;

    @GetMapping("/home")
    public String homePage(Model model){

        model.addAttribute("home",studentService.studentList());

        return "home-page";
    }

    @GetMapping("/registration")
    public String registerStudentPage(Model model){
        Student stud = new Student();
        model.addAttribute("student", stud);
        return "registrar";
    }

    @PostMapping("/register")
    public String registerStudentInDb(@ModelAttribute("student") Student theStudent){
        Student savedStudent = studentService.registerStudent(theStudent);
        if(savedStudent != null){
            return "redirect:/home";
        }
        return "registrar";
    }
    @GetMapping("/home/update/{id}")
    public String editStudent(@PathVariable String id, Model model){
        model.addAttribute("student", studentService.findStudentByStudentId(id));
        return "update";
    }
      @PostMapping("/home/{id}")
    public String updateStudent(@PathVariable String id,
                                @ModelAttribute("student") Student student, Model model)
      {
          Student existingStudent=studentService.findStudentByStudentId(id);
          existingStudent.setTel(student.getTel());
          existingStudent.setId(student.getId());
          existingStudent.setName(student.getName());
          existingStudent.setEmail(student.getEmail());
          existingStudent.setDpt(student.getDpt());
          studentService.updateStudent(existingStudent);
           return "redirect:/home";
      }
 @GetMapping("/home/{id}")
    public String deleteStudent(@PathVariable String id)
 {
     studentService.deleteStudent(id);
     return "redirect:/home";
 }
}
