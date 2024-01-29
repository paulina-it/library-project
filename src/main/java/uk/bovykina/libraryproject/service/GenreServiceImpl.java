package uk.bovykina.libraryproject.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uk.bovykina.libraryproject.dto.*;
import uk.bovykina.libraryproject.model.Book;
import uk.bovykina.libraryproject.model.Genre;
import uk.bovykina.libraryproject.repository.BookRepository;
import uk.bovykina.libraryproject.repository.GenreRepository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;


@Service
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService {
    private final GenreRepository genreRepository;

    DataSource dataSource;
    private final BookRepository bookRepository;

    @Override
    public GenreDto getGenreById(Long id) {
        Genre genre = genreRepository.findById(id).orElseThrow();
        return convertToDto(genre);
    }
    @Override
    public GenreDto getGenreWithBooksById(Long id) {
        List<Book> allBooks = bookRepository.findAll();
        Genre genre = genreRepository.findById(id).orElseThrow();
        GenreDto result = convertToDto(genre);
        List<BookGenreDto> books = new ArrayList<>();

        for (Book b: allBooks) {
            if (b.getGenre() == genre) {
                books.add(convertBookToDto(b));
            }
        }

        result.setBooks(books);

        return result;
    }
    private GenreDto convertToDto(Genre genre) {
        return GenreDto.builder()
                .id(genre.getId())
                .name(genre.getName())
                .build();
    }
    private BookGenreDto convertBookToDto(Book book) {

        List<AuthorGenreDto> authorDtoList = book.getAuthors()
                .stream()
                .map(author -> AuthorGenreDto.builder()
                        .id(author.getId())
                        .name(author.getName())
                        .surname(author.getSurname())
                        .build()
                ).toList();
        return BookGenreDto.builder()
                .id(book.getId())
                .name(book.getName())
//                .genre(book.getGenre().getName())
                .authors(authorDtoList)
                .build();
    }
}
