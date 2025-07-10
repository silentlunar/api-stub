package com.bell.springstub.controller;

import com.bell.springstub.model.User;
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
        return ResponseEntity.ok("{\"login\":\"Login1\",\"status\":\"ok\"}");
    }

    @PostMapping("/post")
    public ResponseEntity<User> post(@Valid @RequestBody User user) {
        makeDelay();
        user.setDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        return ResponseEntity.ok(user);
    }

    private void makeDelay() {
        try {
            Thread.sleep(1000 + (long) (Math.random() * 1000));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}