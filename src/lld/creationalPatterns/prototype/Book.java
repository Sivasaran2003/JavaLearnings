package lld.creationalPatterns.prototype;

import java.util.ArrayList;
import java.util.List;

public class Book implements Cloneable{

    List<String> books;

    public Book() {
        books = new ArrayList<>();
    }

    public List<String> getBooks() {
        return books;
    }

    public void loadData() {
        books.add("book1");
        books.add("book2");
        books.add("book3");
    }

    public Book(Book book) {
        this.books = new ArrayList<>(book.getBooks());
    }

//    @Override
//    public Object clone() throws CloneNotSupportedException {
//        return super.clone();
//    }

    @Override
    public String toString() {
        String books = "";

        for(String i : this.books) {
            books += i + "\n";
        }

        return books;
    }

    @Override
    public Book clone() throws CloneNotSupportedException{
        Book book = new Book(this);
        return book;
    }
}
