package uk.bovykina.libraryproject.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class AuthorCreateDto {
    @Size(min = 3, max = 12)
    @NotBlank(message = "Необходимо указать имя")
    private String name;
    @Size(min = 3, max = 20)
    @NotBlank(message = "Необходимо указать фамилию")
    private String surname;
}