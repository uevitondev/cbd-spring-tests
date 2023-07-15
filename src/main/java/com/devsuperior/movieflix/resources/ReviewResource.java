package com.devsuperior.movieflix.resources;

import com.devsuperior.movieflix.dto.NewReviewDTO;
import com.devsuperior.movieflix.dto.ReviewDTO;
import com.devsuperior.movieflix.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/reviews")
public class ReviewResource {

    @Autowired
    private ReviewService reviewService;

    @PostMapping
    public ResponseEntity<NewReviewDTO> insertNewReview(@RequestBody @Valid ReviewDTO reviewDTO) {

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/").buildAndExpand().toUri();
        return ResponseEntity.created(uri).body(reviewService.insertNewReview(reviewDTO));
    }

}
