package motorcycle.model;

import java.io.Serializable;

public class SampleProduct implements Serializable {
    private long id;
    private String brand;
    private String type;
    private String line;
    private String color;
    private String year;

    public SampleProduct(){}

    public SampleProduct(long id, String brand, String type, String line, String color, String year) {
        this.id = id;
        this.brand = brand;
        this.type = type;
        this.line = line;
        this.color = color;
        this.year = year;
    }

    public SampleProduct(String brand, String type, String line, String color, String year) {
        this.brand = brand;
        this.type = type;
        this.line = line;
        this.color = color;
        this.year = year;
    }

    public long getId() {	return id; }
    public void setId(long id) { this.id = id; }

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

    public String getYear() { return year; }
    public void setYear(String year) {
        this.year = year;
    }


    public SampleProduct(String raw) {
        String[] fields = raw.split(",");
        id = Long.parseLong(fields[0]);
        brand = fields[1];
        type = fields[2];
        line = fields[3];
        color = fields[4];
        year = fields[5];
    }
    @Override
    public String toString() {
        return String.format("%d,%s,%s,%s,%s,%s",id,brand,type,line,color,year);

    }
    public static void transferFields(SampleProduct oldSample,SampleProduct newSample) {
        oldSample.id = newSample.id;
        oldSample.brand = newSample.brand;
        oldSample.type = newSample.type;
        oldSample.line = newSample.line;
        oldSample.color = newSample.color;
        oldSample.year = newSample.year;
    }
}
