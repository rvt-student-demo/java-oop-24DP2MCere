package rvt.Jmooc92;

public class Book implements Packable {
    private String writer;
    private String book;
    private Double weight;

    public Book(String writer, String book, Double weight) {
        this.writer = writer;
        this.book = book;
        this.weight = weight;

    }

    public double weight() {
        return this.weight;
    }

    public String toString() {
        return this.writer + ":" + this.book;
    }
}
