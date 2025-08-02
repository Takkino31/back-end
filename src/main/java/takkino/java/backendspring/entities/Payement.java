package takkino.java.backendspring.entities;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;

@Entity
@AllArgsConstructor @NoArgsConstructor @Getter @Setter @Builder
public class Payement {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    private double amount;
    private PayementType type;

    private PayementStatus status = PayementStatus.CREATED;
    private String file;

    @ManyToOne
    private Student student;
}
