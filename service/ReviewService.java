package com.olp.service;

import com.olp.dto.ReviewDTO;
import java.util.List;

public interface ReviewService {
    ReviewDTO addReview(ReviewDTO reviewDTO);
    ReviewDTO updateReview(Long id, ReviewDTO reviewDTO);
    void deleteReview(Long id);
    ReviewDTO getReviewById(Long id);
    List<ReviewDTO> getReviewsByCourse(Long courseId);
    List<ReviewDTO> getReviewsByUser(Long userId);
}
