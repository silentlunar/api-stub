package com.bell.springstub.controller;

import com.bell.springstub.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class StubController {

    @GetMapping("/get")
    public ResponseEntity<String> get() {
        makeDelay();
        return ResponseEntity.ok("{\"login\":\"Login1\",\"status\":\"ok\"}");
    }

    @PostMapping("/post")
    public ResponseEntity<?> post(@RequestBody Map<String, String> request) {
        makeDelay();

        if (request.get("login") == null || request.get("password") == null) {
            return ResponseEntity.badRequest().body("{\"error\":\"Требуются логин и пароль\"}");
        }

        if (request.get("login").isEmpty() || request.get("password").isEmpty()) {
            return ResponseEntity.badRequest().body("{\"error\":\"Логин и пароль не могут быть пустыми\"}");
        }

        if (request.size() > 2) {
            return ResponseEntity.badRequest().body("{\"error\":\"Допустимы только логин и пароль\"}");
        }

        User response = new User();
        response.setLogin(request.get("login"));
        response.setPassword(request.get("password"));
        response.setDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));

        return ResponseEntity.ok(response);
    }

    private void makeDelay() {
        try {
            Thread.sleep(1000 + (long) (Math.random() * 1000));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}