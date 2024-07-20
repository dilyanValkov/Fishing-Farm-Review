package com.zasmyano.Fishing_Farm_Review.repository;

import com.zasmyano.Fishing_Farm_Review.domain.Review;
import org.hibernate.sql.Delete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findAllByUser(Long id);

    void deleteAllByUser(Long id);
}
