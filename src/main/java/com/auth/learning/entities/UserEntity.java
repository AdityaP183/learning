package com.auth.learning.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "user_id")
    private UUID id;
    @Column(unique = true)
    private String email;
    private String name;
    private String password;
    private String image;
    private boolean isVerified = true;
    private Instant createdAt = Instant.now();
    private Instant updatedAt = Instant.now();

    @Enumerated(EnumType.STRING)
    private Provider provider = Provider.LOCAL;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();

    @PrePersist
    protected void onCreate(){
        Instant now = Instant.now();

        if(this.createdAt == null) this.createdAt = now;
        if(this.updatedAt == null) this.updatedAt = now;
    }

    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = Instant.now();
    }
}
