package uk.bovykina.libraryproject.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;
import uk.bovykina.libraryproject.service.AuthorService;

@Controller
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @GetMapping("/authors")
    String getAuthorsView(Model model) {
        model.addAttribute("authors", authorService.getAllAuthors());
        return "authors";
    }

    // @PostMapping("/author/create")
    // AuthorDto createAuthor(@RequestBody @Valid AuthorCreateDto authorCreateDto) {
    //     return authorService.createAuthor(authorCreateDto);
    // }
}