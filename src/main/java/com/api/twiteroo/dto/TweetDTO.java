package com.api.twiteroo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record TweetDTO(

    @NotNull @Size(min = 2, max =30) String username,

    @NotNull @NotBlank String avatar,

        @NotNull @NotBlank String text

) {
}
