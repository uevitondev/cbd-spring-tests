package com.devsuperior.movieflix.dto;

import com.devsuperior.movieflix.entities.Review;

import java.io.Serializable;

public class NewReviewDTO implements Serializable {
    private Long id;
    private String text;
    private Long movieId;
    private UserDTO user;

    public NewReviewDTO() {
    }

    public NewReviewDTO(Long id, String text, Long movieId, UserDTO user) {
        this.id = id;
        this.text = text;
        this.movieId = movieId;
        this.user = user;
    }

    public NewReviewDTO(Review review) {
        this.id = review.getId();
        this.text = review.getText();
        this.movieId = review.getMovie().getId();
        this.user = new UserDTO(review.getUser());
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }
}
