package vn.tnh.maket.motorcycle.repository;

import vn.tnh.maket.motorcycle.model.News;

import java.util.List;

public interface INewsRepository {
	News getById(long id) ;
	
	
	List<News> getNewsList()  ;
	
	Boolean exist(long id)  ;
	
	void add(News news) ;
	
	void update(News news);
	
}

