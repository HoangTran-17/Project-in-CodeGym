package vn.tnh.maket.motorcycle.services;

import vn.tnh.maket.motorcycle.model.News;

import java.util.List;

public interface INewsService {
	News getById(long id) throws Exception;
	
	List<News> getNewsList() throws Exception;
	
	void create(News news) throws Exception;
	
	void update(News news) throws Exception;
	
}

