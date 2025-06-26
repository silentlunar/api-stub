package com.bell.springstub.controller;

import com.bell.springstub.model.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/api")
public class StubController {

    @GetMapping("/get")
    public ResponseEntity<String> get() {
        String response = "{\"login\":\"Login1\",\"status\":\"ok\"}";
        return ResponseEntity.ok(response);
    }

    @PostMapping("/post")
    public ResponseEntity<UserDTO> post(@RequestBody UserDTO userDTO) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        userDTO.setDate(sdf.format(new Date()));

        try {
            Thread.sleep(1000 + (long) (Math.random() * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return ResponseEntity.ok(userDTO);
    }
}
