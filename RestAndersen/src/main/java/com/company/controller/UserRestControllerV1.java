package com.company.controller;

import com.company.model.dto.UserDto;
import com.company.model.User;
import com.company.model.dto.UserUpdateDto;
import com.company.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/v1/users")
public class UserRestControllerV1 {

    @Autowired
    private UserService userService;
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    private static final String TOPIC = "Kafka_Example";

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {
        User user = userService.getById(id);

        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        UserDto result = UserDto.fromUser(user);
        kafkaTemplate.send("Kafka_Example", "oker");
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> findAllActive() {
        List<UserDto> result = userService.getAllActive().stream()
                .map(UserDto::fromUser).collect(Collectors.toList());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> update(@PathVariable Long id, @RequestBody UserUpdateDto userUpdateDto) {
        User user = userService.getById(id);

        userUpdateDto.applyChanges(user);

        return new ResponseEntity<>(UserDto.fromUser(userService.update(user)), HttpStatus.OK);
    }

}