package com.company.controller;

import com.company.model.Role;
import com.company.model.Status;
import com.company.model.User;
import com.company.model.dto.AdminUserDto;
import com.company.model.dto.UserUpdateDto;
//import com.company.producer.ProducerService;
import com.company.service.RoleServiceImpl;
import com.company.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminRestControllerV1 {

//    @Autowired
//    private KafkaTemplate<String, String> kafkaTemplate;
//    private static final String TOPIC = "Kafka_Example";
    @Autowired
    private UserService userService;
    @Autowired
    private RoleServiceImpl roleService;

    @GetMapping("/users/{id}")
    public ResponseEntity<AdminUserDto> getUserById(@PathVariable Long id) {
        User user = userService.getById(id);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        AdminUserDto result = AdminUserDto.fromUser(user);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/users")
    public ResponseEntity<List<AdminUserDto>> getAllUsers() {
        List<AdminUserDto> result = userService.getAll().stream()
                .map(AdminUserDto::fromUser).collect(Collectors.toList());

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping("/users/role/{id}")
    public ResponseEntity<AdminUserDto> changeUserRoles(@PathVariable Long id, @RequestBody List<String> roles) {
        User user = userService.getById(id);
        List<Role> userRoles = roles.stream().map(roleService::findByName).collect(Collectors.toList());
        user.setRoles(userRoles);

        return new ResponseEntity<>(AdminUserDto.fromUser(userService.update(user)), HttpStatus.OK);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<AdminUserDto> updateUser(@PathVariable Long id, @RequestBody UserUpdateDto userUpdateDto) {
        User user = userService.getById(id);
        userUpdateDto.applyChanges(user);

        return new ResponseEntity<>(AdminUserDto.fromUser(userService.update(user)), HttpStatus.OK);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        User user = userService.getById(id);
        user.setStatus(Status.DELETED);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
