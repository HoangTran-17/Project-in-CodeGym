package motorcycle.services;

import motorcycle.exception.ExitsException;
import motorcycle.exception.NotFoundException;
import motorcycle.model.News;
import motorcycle.repository.INewsRepository;
import motorcycle.repository.NewsRepository;


import java.util.List;

public class NewsService implements INewsService {
	private INewsRepository newsRepository;
	
	public NewsService() {
		newsRepository = new NewsRepository();
	}
	@Override
	public News getById(long id) {
		News news = newsRepository.getById(id);
		if (news == null) {
			throw new NotFoundException("Product is not exist!");
		}
		return news;
	}

	@Override
	public List<News> getNews() {
		return newsRepository.getNew();
	}

//	@Override
//	public List<News> getNewsList() throws Exception {
//		return newsRepository.getNewsList();
//	}
	
	@Override
	public void create(News newNews) {
		if (newsRepository.exist(newNews.getId())) {
			throw new ExitsException("Product is existed!");
		}
		newsRepository.add(newNews);
	}
	
	@Override
	public News update(News news) {
		if (!newsRepository.exist(news.getId())) {
			throw new NotFoundException("Product isn't exist!");
		}
		newsRepository.update(news);
		return news;
	}

	@Override
	public List<News> selectAllNews() {
		List<News> newsList = newsRepository.selectAllNews();

		if (newsList == null)
			throw new NotFoundException("drink not already exists");
		newsRepository.selectAllNews();


		return newsList;
	}

}
