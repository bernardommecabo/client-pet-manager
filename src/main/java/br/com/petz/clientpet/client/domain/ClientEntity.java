package br.com.petz.clientpet.client.domain;

import br.com.petz.clientpet.pet.domain.PetEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "clients")
public class ClientEntity {
    @Id
    @GeneratedValue
    @Column(columnDefinition = "uuid", nullable = false, updatable = false)
    private UUID clientId;

    @OneToMany(mappedBy = "client",  cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<PetEntity> pets = new ArrayList<>();

    @NotBlank
    @Setter
    private String fullName;

    @NotBlank
    @Email
    @Column(unique = true)
    private String email;

    @NotBlank
    @Setter
    private String mobilePhoneNumber;

    @Setter
    private String homePhoneNumber;

    @Enumerated(EnumType.STRING)
    @Setter
    private Gender gender;

    @NotNull
    @Setter
    private LocalDate birthDate;

    @CPF
    @Column(unique = true)
    private String cpf;

    @NotNull
    @Setter
    private Boolean agreesOnTermsAndConditions;

    private LocalDateTime createdAt;
    private LocalDateTime lastUpdatedAt;

    @PrePersist
    protected void onCreate(){
        this.createdAt = LocalDateTime.now();
        this.lastUpdatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate(){
        this.lastUpdatedAt = LocalDateTime.now();
    }
}
