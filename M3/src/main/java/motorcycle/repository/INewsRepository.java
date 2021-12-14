package motorcycle.repository;

import motorcycle.model.News;

import java.util.List;

public interface INewsRepository {
	News getById(long id) ;
	
	
	List<News> getNew()  ;
	
	Boolean exist(long id)  ;
	
	void add(News news) ;
	
	News update(News news);

	List<News> selectAllNews();
	
}

