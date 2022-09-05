package com.ssafy.fit.review;

public class Review {
	private int videoNO;
	private int reviewNo;
	private String name, content;
	
	public Review() {}

	public Review(int videoNO, int reviewNo, String name, String content) {
		this.videoNO = videoNO;
		this.reviewNo = reviewNo;
		this.name = name;
		this.content = content;
	}

	public int getVideoNO() {
		return videoNO;
	}

	public void setVideoNO(int videoNO) {
		this.videoNO = videoNO;
	}

	public int getReviewNo() {
		return reviewNo;
	}

	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}

	public String getname() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return videoNO +" "+ name + " "+ content;
	}
	
	
}
