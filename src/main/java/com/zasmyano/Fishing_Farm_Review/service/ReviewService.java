package com.zasmyano.Fishing_Farm_Review.service;

import com.zasmyano.Fishing_Farm_Review.domain.dto.AddReviewDto;
import com.zasmyano.Fishing_Farm_Review.domain.dto.ReviewDto;

import java.util.List;

public interface ReviewService {
    void createReview(AddReviewDto addReviewDto);

    void deleteReview(Long reviewId);

    ReviewDto getReviewById(Long id);

    List<ReviewDto> getAllReviews();

    List<ReviewDto> getAllReviewsByUserId(Long userId);
}
