package vn.tnh.maket.motorcycle.model;

public class News {
	private long id;
	private int userId;
	private String brand;
	private String type;
	private String line;
	private String color;
	private int year;
	private String km;
	private double price;
	private String description;

	public News(){}

	public News(long id, int userId, String brand, String type, String line, String color, int year, String km, double price, String description) {
		this.id = id;
		this.userId = userId;
		this.brand = brand;
		this.type = type;
		this.line = line;
		this.color = color;
		this.year = year;
		this.km = km;
		this.price = price;
		this.description = description;
	}

	public long getId() {	return id; }
	public void setId(long id) { this.id = id; }

	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getType() { return type; }
	public void setType(String type) { this.type = type;	}

	public String getLine() {
		return line;
	}
	public void setLine(String line) {
		this.line = line;
	}

	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}

	public int getYear() { return year; }
	public void setYear(int year) {
		this.year = year;
	}

	public String getKm() { return km; }
	public void setKm(String km) {this.km = km;}

	public double getPrice() { return price; }
	public void setPrice(double price) { this.price = price;}

	public String getDescription() { return description;}
	public void setDescription(String description) {
		this.description = description;
	}

	public static void transferFields(News oldNews, News newNews) {
		oldNews.id = newNews.id;
		oldNews.userId = newNews.userId;
		oldNews.brand = newNews.brand;
		oldNews.type = newNews.type;
		oldNews.line = newNews.line;
		oldNews.color = newNews.color;
		oldNews.year = newNews.year;
		oldNews.km = newNews.km;
		oldNews.price = newNews.price;
		oldNews.description = newNews.description;
	}

	@Override
	public String toString() {
        return String.format("%-10s %-10s %-10s %-10s %-8s %-15s %,17.0f vnđ", brand, type, line, color, year, km, price);
	}
}
