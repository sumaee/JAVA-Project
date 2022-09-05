package com.ssafy.fit.model.dao;

import java.util.List;

import com.ssafy.fit.model.Video;

public interface IVideoDao {
	List<Video> selectVideo();
	Video selectVideoByNo(int no);
}
