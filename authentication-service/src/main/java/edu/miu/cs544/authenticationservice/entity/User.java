package edu.miu.cs544.authenticationservice.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstname;
    private String lastname;
    @Column(unique=true)
    private String email;
    private String password;
    private boolean active = true;

    @ManyToMany(fetch = FetchType.EAGER)
    @JsonBackReference(value = "roles")
    private List<Role> roles;
}
