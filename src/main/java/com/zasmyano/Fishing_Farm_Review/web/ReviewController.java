package com.zasmyano.Fishing_Farm_Review.web;

import com.zasmyano.Fishing_Farm_Review.domain.dto.AddReviewDto;
import com.zasmyano.Fishing_Farm_Review.domain.dto.ReviewDto;
import com.zasmyano.Fishing_Farm_Review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping("/{id}")
    public ResponseEntity<ReviewDto> findById(@PathVariable("id") Long id){
        return ResponseEntity.ok(reviewService.getReviewById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ReviewDto> deleteById(@PathVariable("id") Long id){
       reviewService.deleteReview(id);
       return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<ReviewDto>> getAllReviews(){
        return ResponseEntity.ok(reviewService.getAllReviews());
    }

    @PostMapping("/add")
    public ResponseEntity<ReviewDto> createOffer(@RequestBody AddReviewDto reviewDto) {
        reviewService.createReview(reviewDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/user{id}")
    public ResponseEntity<List<ReviewDto>>getAllUserReviews(@PathVariable("id")Long id){
        return ResponseEntity.ok(reviewService.getAllReviewsByUserId(id));
    }
}

