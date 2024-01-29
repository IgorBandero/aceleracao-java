package com.tweteroo.api.dtos;

import org.hibernate.validator.constraints.URL;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserDTO {        
    @NotBlank(message = "Username is needed!")
    @Size(max = 100, message = "Username must have a maximum of 100 characters")
    private String username;

    @NotBlank(message = "Avatar image URL is needed!")
    @URL(message = "Invalid image URL!")
    private String avatar;
}
