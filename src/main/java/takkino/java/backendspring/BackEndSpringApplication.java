package takkino.java.backendspring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import takkino.java.backendspring.entities.Payement;
import takkino.java.backendspring.entities.PayementType;
import takkino.java.backendspring.entities.Student;
import takkino.java.backendspring.repositories.PayementRepository;
import takkino.java.backendspring.repositories.StudentRepository;

import java.time.LocalDate;
import java.util.Random;
import java.util.UUID;

@SpringBootApplication
public class BackEndSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackEndSpringApplication.class, args);
    }

    @Bean
    CommandLineRunner init(StudentRepository studentRepository, PayementRepository payementRepository) {
        return args -> {
            studentRepository.save(Student.builder().id(UUID.randomUUID().toString()).firstName("Yaya").lastName("War").code("112233").build());
            studentRepository.save(Student.builder().id(UUID.randomUUID().toString()).firstName("Selly").lastName("Ba").code("112244").build());
            studentRepository.save(Student.builder().id(UUID.randomUUID().toString()).firstName("Mouhamad").lastName("Lo").code("112255").build());

            PayementType [] payementTypes = PayementType.values();
            Random random = new Random();
            studentRepository.findAll().forEach(student -> {
                for (int i = 0; i < 10; i++) {
                    int index = random.nextInt(payementTypes.length);
                    Payement payement = Payement.builder()
                            .amount(1000+(int)(Math.random()*10000))
                            .date(LocalDate.now())
                            .type(payementTypes[index])
                            .file(UUID.randomUUID()+".jpeg")
                            .student(student)
                    .build();
                    payementRepository.save(payement);
                }
            });
        };
    }
}
