package br.com.micro.api.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@NoArgsConstructor
@AllArgsConstructor
@Builder

public class UserDTO {

    @NotEmpty(message = "The field 'name' is required")
    private String name;

    @NotEmpty(message = "The field 'email' is required")
    @Valid
    private String email;

}
