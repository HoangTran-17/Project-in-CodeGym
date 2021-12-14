package motorcycle.services;


import motorcycle.model.News;

import java.util.List;

public interface INewsService {

	News getById(long id);
	
	List<News>getNews();
	
	void create(News news);
	
	News update(News news);

	List<News> selectAllNews();
	
}

