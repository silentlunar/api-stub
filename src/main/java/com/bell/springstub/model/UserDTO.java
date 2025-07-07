package com.bell.springstub.model;

import lombok.Data;
import jakarta.validation.constraints.NotBlank;

@Data
public class UserDTO {

    @NotBlank(message = "Логин не должен быть пустым")
    private String login;

    @NotBlank(message = "Пароль не должен быть пустым")
    private String password;

    private String date;
}