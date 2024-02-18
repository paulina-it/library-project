package uk.bovykina.libraryproject.dto;

import lombok.*;
import uk.bovykina.libraryproject.model.Genre;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BookUpdateDto {
    private Long id;
    private String name;
    private Genre genre;
}
