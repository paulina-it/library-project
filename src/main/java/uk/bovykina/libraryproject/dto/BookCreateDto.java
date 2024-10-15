package uk.bovykina.libraryproject.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uk.bovykina.libraryproject.model.Genre;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BookCreateDto {
    @Size(min = 3)
    @NotBlank(message = "Необходимо указать название книги")
    private String name;
    @Size(min = 3)
    @NotBlank(message = "Необходимо указать жанр книги")
    private Genre genre;
}
