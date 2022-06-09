package edu.miu.cs544.authenticationservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private int id;
    private String email;
    private String firstname;
    private String lastname;
    private boolean active;

    private List<RoleDTO> roles;
}
