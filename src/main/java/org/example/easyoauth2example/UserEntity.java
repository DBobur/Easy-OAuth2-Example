package org.example.easyoauth2example;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Table
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String clientId;
    private String name;
    private String email;
    private String password;
}
