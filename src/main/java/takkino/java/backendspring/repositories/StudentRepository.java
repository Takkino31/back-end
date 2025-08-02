package takkino.java.backendspring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;
import takkino.java.backendspring.entities.Student;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, String> {
    Student findByCode(String code);

//    List<Object> findById(Long code);
}
