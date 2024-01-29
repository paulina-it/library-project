package uk.bovykina.libraryproject.service;

import uk.bovykina.libraryproject.dto.GenreDto;

public interface GenreService {

    GenreDto getGenreById(Long id);
    GenreDto getGenreWithBooksById(Long genreId);
}
