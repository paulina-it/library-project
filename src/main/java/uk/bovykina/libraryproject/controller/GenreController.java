package uk.bovykina.libraryproject.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import uk.bovykina.libraryproject.dto.GenreDto;
import uk.bovykina.libraryproject.service.GenreService;



@RestController
@RequiredArgsConstructor
public class GenreController {

    private final GenreService genreService;

    @GetMapping("/genres/{id}")
    GenreDto getGenreByGenreId(@PathVariable("id") Long id) {
        return genreService.getGenreById(id);
    }

    @GetMapping("/genre/{id}")
    GenreDto getBooksByGenreId(@PathVariable("id") Long id) {
        return genreService.getGenreWithBooksById(id);
    }
}
