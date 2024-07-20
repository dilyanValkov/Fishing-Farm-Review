package com.zasmyano.Fishing_Farm_Review.service;

import com.zasmyano.Fishing_Farm_Review.domain.Review;
import com.zasmyano.Fishing_Farm_Review.domain.dto.AddReviewDto;
import com.zasmyano.Fishing_Farm_Review.domain.dto.ReviewDto;
import com.zasmyano.Fishing_Farm_Review.repository.ReviewRepository;
import com.zasmyano.Fishing_Farm_Review.service.exception.ObjectNotFountException;
import jakarta.transaction.Transactional;
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
    public Long createReview(AddReviewDto addReviewDto) {
        Review review = modelMapper.map(addReviewDto, Review.class);
        return reviewRepository.save(review).getId();
    }

    @Override
    @Transactional
    public void deleteAllReviews(Long id) {
        this.reviewRepository.deleteAllByUser(id);
    }

    @Override
    public ReviewDto getReviewById(Long id) {
        return reviewRepository.findById(id)
                .map(review -> modelMapper.map(review, ReviewDto.class))
                .orElseThrow(()-> new ObjectNotFountException ("Review with id " + id + " is not found!", "/review/add/" + id));
    }

    @Override
    public List<ReviewDto> getAllReviews() {
        return this.reviewRepository.findAll()
                .stream().map(review -> modelMapper.map(review, ReviewDto.class))
                .toList();
    }

    @Override
    public List<ReviewDto> getAllReviewsByUserId(Long userId) {
      return this.reviewRepository.findAllByUser(userId)
              .stream().map(review -> modelMapper.map(review,ReviewDto.class))
              .toList();
    }
}
