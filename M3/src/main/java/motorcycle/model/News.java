package motorcycle.model;

import java.io.Serializable;

public class News implements Serializable {
	private long id;
	private long userId;
	private String brand;
	private String type;
	private String line;
	private String color;
	private int year;
	private String km;
	private double price;
	private String description;

	public News(){}

	public News(long id, long userId, String brand, String type, String line, String color, int year, String km, double price, String description) {
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

	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
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
        return String.format("%-10s %-10s %-10s %-10s %-8s %-15s %,17.0f vn??", brand, type, line, color, year, km, price);
	}
	public News(String raw) {
		String[] fields = raw.split(",");
		id = Long.parseLong(fields[0]);
		userId = Long.parseLong(fields[1]);
		brand = fields[2];
		type = fields[3];
		line = fields[4];
		color = fields[5];
		year = Integer.parseInt(fields[6]);
		km = fields[7];
		price = Double.parseDouble(fields[8]);
		description = fields[9];
	}
}

