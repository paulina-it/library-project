package uk.bovykina.libraryproject.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uk.bovykina.libraryproject.model.Role;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CreateUserDto {
    @Size(min = 3)
    @NotBlank(message = "Необходимо указать имя пользователя")
    private String username;

    @Size(min = 8, message = "Пароль должен содержать минимум 8 символов")
    @NotBlank(message = "Необходимо указать пароль")
    private String password;
    
    @NotBlank(message = "Необходимо выбрать тип пользователя")
    private Role role;
}
