package com.devsuperior.movieflix.services;

import com.devsuperior.movieflix.dto.NewReviewDTO;
import com.devsuperior.movieflix.dto.ReviewDTO;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.entities.User;
import com.devsuperior.movieflix.repositories.MovieRepository;
import com.devsuperior.movieflix.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private AuthService authService;

    @PreAuthorize("hasAnyRole('MEMBER')")
    @Transactional(readOnly = true)
    public NewReviewDTO insertNewReview(ReviewDTO reviewDTO) {
        User user = authService.authenticated();
        Movie movie = movieRepository.getOne(reviewDTO.getMovieId());

        Review review = new Review();
        review.setId(null);
        review.setText(reviewDTO.getText());
        review.setUser(user);
        review.setMovie(movie);

        review = reviewRepository.save(review);
        return new NewReviewDTO(review);
    }

}
