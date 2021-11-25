package vn.tnh.maket.motorcycle.services;

import vn.tnh.maket.motorcycle.repository.NewsRepository;
import vn.tnh.maket.motorcycle.model.News;

import java.util.List;

public class NewsService implements INewsService {
	private NewsRepository newsRepository;
	
	public NewsService() {
		newsRepository = new NewsRepository();
	}
	@Override
	public News getById(long id) throws Exception {
		News news = newsRepository.getById(id);
		if (news == null) {
			throw new Exception("Product is not exist!");
		}
		return news;
	}
	
	@Override
	public List<News> getNewsList() throws Exception {
		return newsRepository.getNewsList();
	}
	
	@Override
	public void create(News newNews) throws Exception {
		if (newsRepository.exist(newNews.getId())) {
			throw new Exception("Product is existed!");
		}
		newsRepository.add(newNews);
	}
	
	@Override
	public void update(News news) throws Exception {
		if (!newsRepository.exist(news.getId())) {
			throw new Exception("Product isn't exist!");
		}
		newsRepository.update(news);
	}
	
}
