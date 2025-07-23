package com.craft.studentmanagementsystem.controller;

import com.craft.studentmanagementsystem.model.Student;
import com.craft.studentmanagementsystem.service.StudnetService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    private final StudnetService studentService;

    public StudentController(StudnetService studnetService) {
        this.studentService = studnetService;
    }

    @PostMapping()
    public Student addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }

    @GetMapping()
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Optional<Student> getStudentById(@PathVariable Long id){
        return studentService.getStudentById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteStudentById(@PathVariable Long id){
        studentService.deleteStudentById(id);
        System.out.println("Student deleted with id" + id + " successfully");
    }

    @PutMapping({"/{id}"})
    public Student updateStudent(@RequestBody Student student, @PathVariable Long id){
        return studentService.updateStudent(student, id);
    }

    @GetMapping("/search")
    public Student getStudentByEmail(@RequestParam String email){
        return studentService.findStudentByEmail(email);
    }

    @GetMapping("/search/jpql")
    public List<Student> getStudentsBornBefore(@RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date){
        return studentService.findStudentBornBefore(date);
    }
}
