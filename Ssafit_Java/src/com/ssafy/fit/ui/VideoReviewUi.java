package com.ssafy.fit.ui;

import com.ssafy.fit.review.IReviewManager;
import com.ssafy.fit.review.Review;
import com.ssafy.fit.review.ReviewManagerImpl;
import com.ssafy.fit.user.UserManagerImpl;
import com.ssafy.fit.util.SsafitUtil;

public class VideoReviewUi {
	private static VideoReviewUi instance;
	private static int videoNo;
	IReviewManager rm = ReviewManagerImpl.getInstance();

	private VideoReviewUi(int videoNo) {
		VideoReviewUi.videoNo = videoNo;
		rm = ReviewManagerImpl.getInstance();
	}

	public static VideoReviewUi getInstance() {
		instance = new VideoReviewUi(videoNo);
		return instance;
	}

	public void service(int videoNo) {
		while (true) {

			SsafitUtil.printLine();
			int count;
			if (rm.getListReview() == null) {
				count = 0;
			} else {
				count = rm.searchByvideoNo(videoNo - 1).size();
			}

			System.out.printf("영상리뷰: %d 개\n", count);

			SsafitUtil.printLine();
			if (rm.searchByvideoNo(videoNo - 1) == null) {
				return;
			} else {
				for (Review r : rm.searchByvideoNo(videoNo - 1)) {
					System.out.println(r);
				}

			}
			SsafitUtil.printLine();

			System.out.println("1. 리뷰등록");
			System.out.println("0. 이전으로");
			SsafitUtil.printLine();
			int n = SsafitUtil.inputInt("메뉴를 선택하세요");
			if (n == 1) {
				String name = UserManagerImpl.getInstance().getLoginName();
				String con = SsafitUtil.input("내용을 입력하세요");
				Review r = new Review(videoNo, count + 1, name, con);
				rm.addReview(r);
			} else if (n == 0) {
				break;
			} else {
				System.out.println("잘못된 입력입니다.");
			}
		}
	}

}
