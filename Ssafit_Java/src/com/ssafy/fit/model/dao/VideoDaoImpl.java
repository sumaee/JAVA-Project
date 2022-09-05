package com.ssafy.fit.model.dao;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.parser.JSONParser;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ssafy.fit.model.Video;

public class VideoDaoImpl implements IVideoDao{
	private List<Video> list=new ArrayList<>();
	private static VideoDaoImpl instance=new VideoDaoImpl();
	
	private VideoDaoImpl() {
		List<Video> videoList=new ArrayList<>();
		try {
			String st=new JSONParser().parse(new FileReader("data/video.json")).toString();
			videoList=new Gson().fromJson(st, new TypeToken<List<Video>>(){}.getType());
		}catch(Exception e) {
			e.printStackTrace();
		}
		this.list=videoList;
	}
	public static VideoDaoImpl getInstance() {
		return instance;
	}
	
	
	@Override
	public List<Video> selectVideo() {
		//전체 비디오 리스트 반환
		return list;
	}

	@Override
	public Video selectVideoByNo(int no) {
//		해당 no의 비디오 반환
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getNo()==no) {
				return list.get(i);
			}
		}
		return null;
	}
	
}
