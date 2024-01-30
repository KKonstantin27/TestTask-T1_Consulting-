package com.example.TestTask.dtos;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StringQueryDTO {
    @NotEmpty(message = "String query should not be empty")
    private String stringQuery;
}
