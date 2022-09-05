package com.ssafy.fit.ui;

import com.ssafy.fit.model.Video;
import com.ssafy.fit.model.dao.IVideoDao;
import com.ssafy.fit.model.dao.VideoDaoImpl;
import com.ssafy.fit.util.SsafitUtil;

public class VideoUi {
	private IVideoDao videoDao = VideoDaoImpl.getInstance();
	private static VideoUi instance = new VideoUi();

	private VideoUi() {
	}

	public static VideoUi getInstance() {
		return instance;
	}

	public void service() {
		while (true) {
			instance.listVideo();
			SsafitUtil.printLine();
			System.out.println("1. 영상상세");
			System.out.println("0. 이전으로");
			SsafitUtil.printLine();
			int n = SsafitUtil.inputInt("메뉴를 선택하세요");
			if (n == 1) {
				instance.detailVideo();
			} else if (n == 0) {
				break;
			} else {
				System.out.println("잘못된 입력입니다.");
			}

		}
	}

	public void listVideo() {
		SsafitUtil.printLine();
		System.out.println("전체 8개");
		SsafitUtil.printLine();
		for (Video v : videoDao.selectVideo()) {
			System.out.println(v);
		}
	}

	private void detailVideo() {
		while (true) {
			int n = SsafitUtil.inputInt("영상 번호를 입력하세요");
			if (n <= videoDao.selectVideo().size()) {
				Video vn = videoDao.selectVideo().get(n-1);

				SsafitUtil.printLine();
				System.out.printf("번호 : %d\n", vn.getNo());
				System.out.printf("제목 : %s\n", vn.getTitle());
				System.out.printf("운동 : %s\n", vn.getPart());
				System.out.printf("영상URL : %s\n", vn.getUrl());
				SsafitUtil.printLine();
				
				VideoReviewUi tmp = VideoReviewUi.getInstance();
				tmp.service(n);
				break;
			} else {
				System.out.println("잘못된 입력입니다.");
			}
		}
	}

}
