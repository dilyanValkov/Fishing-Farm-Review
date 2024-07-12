package com.zasmyano.Fishing_Farm_Review.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddReviewDto {

    private int rating;

    private String comment;

    private Long usedId;
}
