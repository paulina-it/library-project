package uk.bovykina.libraryproject.dto;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uk.bovykina.libraryproject.model.Role;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserDto {
    @Id
    private Long id;
    private String username;
    private String password;
    private Role role;
}
