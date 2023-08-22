package com.api.twiteroo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UserDTO(

    @NotNull @Size(min = 2, max =30) String username,

    @NotNull @NotBlank String avatar

) {
}
