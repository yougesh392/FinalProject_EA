package edu.miu.cs544.authenticationservice.service.impl;

import edu.miu.cs544.authenticationservice.dto.UserDTO;
import edu.miu.cs544.authenticationservice.dto.UserSaveDTO;
import edu.miu.cs544.authenticationservice.entity.Role;
import edu.miu.cs544.authenticationservice.entity.User;
import edu.miu.cs544.authenticationservice.repository.UserRepository;
import edu.miu.cs544.authenticationservice.service.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public void save(UserSaveDTO t) {
        t.setPassword(new BCryptPasswordEncoder().encode(t.getPassword()));

        userRepository.save(modelMapper.map(t, User.class));
    }

    @Override
    public void delete(int id) {
        var j = userRepository.findById(id);
        if (j.isPresent()){
            userRepository.delete(j.get());
        }
    }

    @Override
    public void update(int id, UserDTO t) {
        var l = userRepository.findById(id);
        if (l.isPresent()){
            l.get().setActive(t.isActive());
            l.get().setFirstname(t.getFirstname());
            l.get().setLastname(t.getLastname());
            l.get().setEmail(t.getEmail());
            l.get().setRoles(t.getRoles().stream().map(r -> modelMapper.map(r, Role.class)).collect(Collectors.toList()));
            userRepository.save(l.get());
        }
    }

    @Override
    public List<UserDTO> findAll() {
        return StreamSupport
                .stream(userRepository.findAll().spliterator(), false)
                .map(u -> modelMapper.map(u, UserDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO findById(int id) {
        var h = userRepository.findById(id);

        return h.isPresent() ? modelMapper.map(h.get(), UserDTO.class) : null;

    }


}
