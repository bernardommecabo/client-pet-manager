package br.com.petz.clientpet.auth.user.domain;

import br.com.petz.clientpet.client.domain.ClientEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "uuid", updatable = false, nullable = false, unique = true)
    private UUID userId;

    @NotBlank
    @Email
    @Column(unique = true)
    @Setter
    private String email;

    @OneToOne(fetch = FetchType.LAZY,optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "clientId", nullable = false, unique = true, updatable = false)
    private ClientEntity client;

    private LocalDateTime createdAt;
    private LocalDateTime lastUpdatedAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.lastUpdatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.lastUpdatedAt = LocalDateTime.now();
    }
}
