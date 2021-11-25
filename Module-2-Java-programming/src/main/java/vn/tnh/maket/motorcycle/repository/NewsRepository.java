package vn.tnh.maket.motorcycle.repository;

import vn.tnh.maket.motorcycle.model.News;
import vn.tnh.maket.motorcycle.utils.JacksonParser;
import vn.tnh.maket.motorcycle.utils.TextFileUtils;

import java.util.ArrayList;
import java.util.List;

public class NewsRepository implements INewsRepository {
	private final String NEWS_PATH = "data\\news.json";
	
	public NewsRepository(){}
	
	@Override
	public News getById(long id) {
		for (News news : getNewsList() ) {
			if (news.getId() == id) { return news;}
		}return null;
	}
	
	@Override
	public List<News> getNewsList() {
		String json = TextFileUtils.read(NEWS_PATH);
		return json.isEmpty() ? new ArrayList<News>() : JacksonParser.INSTANCE.toList(json, News.class);
	}
	
	@Override
	public Boolean exist(long id) { return getById(id) != null;}
	
	@Override
	public void add(News newNews) {
		List<News> news = getNewsList();
		news.add(newNews);
		String json = JacksonParser.INSTANCE.toJson(news);
		TextFileUtils.write(NEWS_PATH, json);
	}
	
	
	@Override
	public void update(News newNews)  {
		List<News> newsList = getNewsList();
		for (News news : newsList) {
			if (news.getId() == newNews.getId()) { News.transferFields(news, newNews);}
		}
		String json = JacksonParser.INSTANCE.toJson(newsList);
		TextFileUtils.write(NEWS_PATH, json);
	}
	
	
	public static void main(String[] args) {
		NewsRepository newsRepository = new NewsRepository();
		newsRepository.add(new News(8430171021L,
				843017102,
				"HONDA",
				"Scooter",
				"SH",
				"White",
				2017,
				"10,000-20,000 km",
				30000000,
				"Xe nữ đi, chăm sóc thường xuyên"));
		List<News> list = newsRepository.getNewsList();
	}
}
