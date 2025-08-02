package takkino.java.backendspring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import takkino.java.backendspring.entities.Payement;
import takkino.java.backendspring.entities.PayementStatus;

import java.util.List;

public interface PayementRepository extends JpaRepository<Payement, String> {
    List<Payement> findByStudentCode(String code);
    List<Payement> findByStudentId(String id);
    List<Payement> findByStatus(PayementStatus status);

}
