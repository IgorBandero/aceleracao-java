package com.tweteroo.api.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class TweetDTO {
    @NotBlank(message = "Tweet not allowed to be empty!")
    @Size(max = 280, message = "Tweet must have a maximum of 280 characters")
    private String text;
}
