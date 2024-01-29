package uk.bovykina.libraryproject.service;

import uk.bovykina.libraryproject.dto.AuthorCreateDto;
import uk.bovykina.libraryproject.dto.AuthorDto;

public interface AuthorService {
    AuthorDto getAuthorById(Long id);
    AuthorDto getByNameV1(String name);
    AuthorDto getByNameV2(String name);
    AuthorDto getByNameV3(String name);

    AuthorDto createAuthor(AuthorCreateDto authorCreateDto);
}