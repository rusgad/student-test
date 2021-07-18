package com.example.studenttest.repository;

import com.example.studenttest.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findByUsernameAndPassword(String username, String password);
    boolean existsByUsernameAndPassword(String username, String password);

}
