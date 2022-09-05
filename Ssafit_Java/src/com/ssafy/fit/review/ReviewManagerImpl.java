package com.ssafy.fit.review;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ReviewManagerImpl implements IReviewManager {
	private List<Review> reviewList = new ArrayList<>();
	private static IReviewManager instance = new ReviewManagerImpl();

	private ReviewManagerImpl() {
		Gson gson = new Gson();
		try (BufferedReader reader = new BufferedReader(new FileReader("data/review.json"))) {
			Review[] review = gson.fromJson(reader, Review[].class);
			for (Review r : review) {
				reviewList.add(r);
			}
		} catch (Exception e) {
			// 없어도 스킵
		}
	}

	public static IReviewManager getInstance() {
		return instance;
	}

	@Override
	public void addReview(Review r) {
		reviewList.add(r);
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		Review[] review = new Review[reviewList.size()];
		try (FileWriter writer = new FileWriter("data/review.json")) {
			for (int i = 0; i < reviewList.size(); i++) {
				review[i] = reviewList.get(i);
			}
			gson.toJson(review, writer);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Review> getListReview() {
		
		return reviewList;
	}

	@Override
	public List<Review> searchByvideoNo(int videoNo) {
		List<Review> result = new ArrayList<>();
		for (Review r : reviewList) {
			if (r.getVideoNO() == (videoNo+1)) {
				result.add(r);
			}
		}
			return result;
	}
}
