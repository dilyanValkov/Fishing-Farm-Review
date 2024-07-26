package com.zasmyano.Fishing_Farm_Review.web;

import com.zasmyano.Fishing_Farm_Review.domain.dto.AddReviewDto;
import com.zasmyano.Fishing_Farm_Review.domain.dto.ReviewDto;
import com.zasmyano.Fishing_Farm_Review.service.ReviewService;
import com.zasmyano.Fishing_Farm_Review.service.exception.ObjectNotFountException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/review")
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping("/add")
    public ResponseEntity<ReviewDto> createReview(@RequestBody AddReviewDto reviewDto) {
        Long reviewId = reviewService.createReview(reviewDto);

        return ResponseEntity.created(ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}").buildAndExpand(reviewId).toUri()).build();
    }


    @GetMapping
    public ResponseEntity<List<ReviewDto>> getAllReviews(){
        return ResponseEntity.ok(reviewService.getAllReviews());
    }


    @GetMapping("/user/{id}")
    public ResponseEntity<List<ReviewDto>>getAllUserReviews(@PathVariable("id") Long id){
        return ResponseEntity.ok(reviewService.getAllReviewsByUserId(id));
    }


    @DeleteMapping("delete/user/{id}")
    public ResponseEntity<ReviewDto> deleteByUserId(@PathVariable("id") Long id){
        reviewService.deleteAllUserReviews(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<ReviewDto> deleteById(@PathVariable("id") Long id){
        reviewService.deleteReviewById(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/{id}")
    public ResponseEntity<ReviewDto> findById(@PathVariable("id") Long id){
        return ResponseEntity.ok(reviewService.getReviewById(id));
    }








    @ExceptionHandler(ObjectNotFountException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public BaseExceptionInfo objectNotFountException(ObjectNotFountException objectNotFountException){
        return new BaseExceptionInfo(objectNotFountException.getMessage(), objectNotFountException.getUrl());
    }
}

