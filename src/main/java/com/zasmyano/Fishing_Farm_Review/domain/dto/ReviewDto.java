package com.zasmyano.Fishing_Farm_Review.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewDto {
    private Long id;
    private int rating;
    private String comment;
    private Long usedId;
}
