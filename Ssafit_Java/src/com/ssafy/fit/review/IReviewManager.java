package com.ssafy.fit.review;

import java.util.List;

public interface IReviewManager {
	void addReview(Review r);
	List<Review> getListReview();
	List<Review> searchByvideoNo(int videoNo);
}
