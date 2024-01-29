package uk.bovykina.libraryproject.service;

import org.springframework.data.jpa.repository.Query;
import uk.bovykina.libraryproject.dto.AuthorDto;
import uk.bovykina.libraryproject.dto.BookDto;
import uk.bovykina.libraryproject.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    BookDto getBookById(Long bookId);

    BookDto getByNameV1(String name);
    BookDto getByNameV2(String name);
    BookDto getByNameV3(String name);
}
