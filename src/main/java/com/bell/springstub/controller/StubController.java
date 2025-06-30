package com.bell.springstub.controller;

import com.bell.springstub.model.UserDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/api")
public class StubController {

    @GetMapping("/get")
    public ResponseEntity<String> get() {
        makeDelay();
        String response = "{\"login\":\"Login1\",\"status\":\"ok\"}";
        return ResponseEntity.ok(response);
    }

    @PostMapping("/post")
    public ResponseEntity<UserDTO> post(@Valid @RequestBody  UserDTO userDTO) {
        makeDelay();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        userDTO.setDate(sdf.format(new Date()));
        return ResponseEntity.ok(userDTO);
    }

    private void makeDelay() {
        try {
            Thread.sleep(1000 + (long) (Math.random() * 1000));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}