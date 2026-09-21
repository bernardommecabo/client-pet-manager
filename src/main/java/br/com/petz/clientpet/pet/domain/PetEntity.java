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
    private String petName;

    @Enumerated(EnumType.STRING)
    private Size size;

    @NotNull
    @Enumerated(EnumType.STRING)
    private PetType petType;

    @Column(updatable = false)
    private String microchipNumber;

    @NotBlank
    private String breed;

    @NotNull
    @Enumerated(EnumType.STRING)
    private PetGender gender;

    private String furColor;

    @NotNull
    private LocalDate birthDate;

    private String RGA;
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
