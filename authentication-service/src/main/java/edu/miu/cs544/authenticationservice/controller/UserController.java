package edu.miu.cs544.authenticationservice.controller;


import edu.miu.cs544.authenticationservice.dto.UserDTO;
import edu.miu.cs544.authenticationservice.dto.UserSaveDTO;
import edu.miu.cs544.authenticationservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/api/v1/users")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody UserSaveDTO h) throws Exception {
        if ("ADMIN".equals(h.getRoles().contains("ADMIN"))) return new ResponseEntity<>("Unauthorized", HttpStatus.UNAUTHORIZED);
        userService.save(h);
        return ResponseEntity.ok().body("");
    }

    @PostMapping("/admin")
    public void saveAdmin(@RequestBody UserSaveDTO h, @RequestHeader(name="Authorization") String token, Principal principal) throws Exception {
        System.out.println(principal.getName());
//        System.out.println(token);
//        System.out.println(Helpers.decode(token));
//
//        User u = new ModelMapper().map(Helpers.decode(token).get(0), User.class);
//        System.out.println(u.getFirstname());
        userService.save(h);
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok().body(userService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable int id) {
        return ResponseEntity.ok().body(userService.findById(id));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id){
        userService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody UserDTO l){
        userService.update(id, l);
    }



}
