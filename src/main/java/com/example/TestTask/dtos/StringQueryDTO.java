package com.example.TestTask.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StringQueryDTO {
    @NotEmpty(message = "String query should not be empty")
    @Size(min = 1, max = 50, message = "String query should be between 1 and 50 characters")
    private String stringQuery;
}
