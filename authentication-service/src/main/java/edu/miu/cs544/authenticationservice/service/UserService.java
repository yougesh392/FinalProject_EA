package edu.miu.cs544.authenticationservice.service;

import edu.miu.cs544.authenticationservice.dto.UserDTO;
import edu.miu.cs544.authenticationservice.dto.UserSaveDTO;

import java.util.List;

public interface UserService {
    void save(UserSaveDTO u);
    void delete(int id);
    void update(int id, UserDTO t);
    List<UserDTO> findAll();
    UserDTO findById(int id);
}
