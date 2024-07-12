package com.zasmyano.Fishing_Farm_Review.service;

import com.zasmyano.Fishing_Farm_Review.domain.Review;
import com.zasmyano.Fishing_Farm_Review.domain.dto.AddReviewDto;
import com.zasmyano.Fishing_Farm_Review.domain.dto.ReviewDto;
import com.zasmyano.Fishing_Farm_Review.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final ModelMapper modelMapper;

    @Override
    public void createReview(AddReviewDto addReviewDto) {
    this.reviewRepository.save(this.modelMapper.map(addReviewDto, Review.class));
    }

    @Override
    public void deleteReview(Long reviewId) {
        this.reviewRepository.deleteById(reviewId);
    }

    @Override

    public ReviewDto getReviewById(Long id) {
        return reviewRepository.findById(id)
                .map(review -> modelMapper.map(review, ReviewDto.class))
                .orElseThrow(()-> new IllegalArgumentException("Review not found!"));
    }

    @Override
    public List<ReviewDto> getAllReviews() {
        return this.reviewRepository.findAll()
                .stream().map(review -> modelMapper.map(review, ReviewDto.class))
                .toList();
    }

    @Override
    public List<ReviewDto> getAllReviewsByUserId(Long userId) {
      return this.reviewRepository.findAllByUsedId(userId)
              .stream().map(review -> modelMapper.map(review,ReviewDto.class))
              .toList();
    }
}
