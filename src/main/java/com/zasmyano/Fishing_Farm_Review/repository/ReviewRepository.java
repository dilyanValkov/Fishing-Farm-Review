package com.zasmyano.Fishing_Farm_Review.repository;

import com.zasmyano.Fishing_Farm_Review.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findAllByUsedId(Long id);
}
