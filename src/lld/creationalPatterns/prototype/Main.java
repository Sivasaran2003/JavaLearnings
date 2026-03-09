package lld.creationalPatterns.prototype;

public class Main {
    public static void main() throws CloneNotSupportedException {
        Book book = new Book();
        book.loadData();
        System.out.println("1.\n" + book);

        // shallow copy - just reference (same object)
        // deep copy - new copy object creation

        Book book1 = book.clone();
        System.out.println("2.\n" + book1);

        book.getBooks().remove(1);
        System.out.println("3.\n" + book1);
    }
}
