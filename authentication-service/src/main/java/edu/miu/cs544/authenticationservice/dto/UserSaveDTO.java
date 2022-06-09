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
public class UserSaveDTO {
    private int id;
    private String email;
    private String password;
    private String firstname;
    private String lastname;
    private List<RoleDTO> roles;
}
