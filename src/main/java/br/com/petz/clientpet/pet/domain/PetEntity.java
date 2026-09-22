package br.com.petz.clientpet.pet.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "pets")
public class PetEntity {
    @Id
    @GeneratedValue
    @Column(columnDefinition = "uuid", nullable = false, updatable = false)
    private UUID petId;

    @Column(name = "clientId", nullable = false, updatable = false)
    private UUID clientId;

    @NotBlank
    @Setter
    private String petName;

    @Enumerated(EnumType.STRING)
    @Setter
    private Size size;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Setter
    private PetType petType;

    @Column(updatable = false)
    @Setter
    private String microchipNumber;

    @NotBlank
    @Setter
    private String breed;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Setter
    private PetGender gender;

    @Setter
    private String furColor;

    @NotNull
    @Setter
    private LocalDate birthDate;

    @Setter
    private String RGA;
    @Setter
    private BigDecimal weight;

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
