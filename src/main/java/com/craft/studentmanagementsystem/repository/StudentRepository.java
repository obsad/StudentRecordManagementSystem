package com.craft.studentmanagementsystem.repository;

import com.craft.studentmanagementsystem.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.Date;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Long> {

    Student findStudentByEmail(String email);

    @Query("Select s from Student s where s.dateOfBirth < :date")
    List<Student> findStudentBornBefore(@Param("date") Date date);
}
