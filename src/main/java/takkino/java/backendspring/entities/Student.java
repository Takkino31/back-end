package takkino.java.backendspring.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@NoArgsConstructor @AllArgsConstructor @Getter @Setter @Builder
public class Student {
    @Id
    private String id;
    @Column(unique = true)
    private String code;
    private String firstName;
    private String lastName;
    private String email;
    private String photo;
}
