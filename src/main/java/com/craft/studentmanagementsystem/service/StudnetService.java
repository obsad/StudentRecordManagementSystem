package com.craft.studentmanagementsystem.service;

import com.craft.studentmanagementsystem.model.Student;
import com.craft.studentmanagementsystem.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class StudnetService {

    private final StudentRepository studentRepository;

    public StudnetService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student addStudent(Student student){
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }
    
    public Optional<Student> getStudentById(Long id){
        return studentRepository.findById(id);
    }

    public void deleteStudentById(Long id){
        studentRepository.deleteById(id);
    }

    public Student updateStudent(Student student, Long id){
        Optional<Student> updatedStudent = studentRepository.findById(id);
        if (updatedStudent.isEmpty()){
            return null;
        }

        Student updatedStudent1 = updatedStudent.get();
        updatedStudent1.setFirstName(student.getFirstName());
        updatedStudent1.setLastName(student.getLastName());
        updatedStudent1.setEmail(student.getEmail());
        updatedStudent1.setDateOfBirth(student.getDateOfBirth());

        return updatedStudent1;
    }

    public Student findStudentByEmail(String email){
        return studentRepository.findStudentByEmail(email);
    }

    public List<Student> findStudentBornBefore(Date date){
        return studentRepository.findStudentBornBefore(date);
    }
}
