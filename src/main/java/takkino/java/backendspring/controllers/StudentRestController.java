package takkino.java.backendspring.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import takkino.java.backendspring.entities.Payement;
import takkino.java.backendspring.entities.Student;
import takkino.java.backendspring.repositories.PayementRepository;
import takkino.java.backendspring.repositories.StudentRepository;

import java.util.List;

@RestController
public class StudentRestController {
    private final PayementRepository payementRepository;
    private final StudentRepository studentRepository;

    public StudentRestController(PayementRepository payementRepository, StudentRepository studentRepository) {
        this.payementRepository = payementRepository;
        this.studentRepository = studentRepository;
    }

    @GetMapping("/payments")
    public List<Payement> getAllPayments() {
        return payementRepository.findAll();
    }

    @GetMapping("/payments/{id}")
    public Payement findPayementById(@PathVariable String id) {
        return payementRepository.findById(id).orElse(null);
    }

    @GetMapping("/students")
    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    @GetMapping("/students/{id}")
    public Student findById(@PathVariable String id) {
        return studentRepository.findById(id).orElse(null);
    }

    @GetMapping("/students/{code}/payments")
    public List<Payement> findStudentPayments(@PathVariable String code) {
        return payementRepository.findByStudentCode(code);
    }
}
