package com.devsuperior.movieflix.resources;

import com.devsuperior.movieflix.dto.MovieDTO;
import com.devsuperior.movieflix.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movies")
public class MovieResource {

    @Autowired
    private MovieService movieService;

    @GetMapping("/{id}")
    public ResponseEntity<MovieDTO> findMovieById(@PathVariable Long id) {
        return ResponseEntity.ok().body(movieService.findMovieById(id));
    }

    @GetMapping()
    public ResponseEntity<Page<MovieDTO>> findMoviesByGenre(@RequestParam(value = "genreId", defaultValue = "0") Long genreId) {
        Pageable pageable = PageRequest.of(0, 12, Sort.by("title").ascending());
        return ResponseEntity.ok().body(movieService.findMoviesByGenre(genreId, pageable));
    }

    @GetMapping("/{id}/reviews")
    public ResponseEntity<MovieDTO> findMovieByIdWithReviews(@PathVariable Long id) {
        return ResponseEntity.ok().body(movieService.findMovieById(id));
    }


}
