import java.util.*;
import java.util.stream.*;

class Book {
    private String title;
    private String author;
    private int year;
    private int pages;

    public Book(String title, String author, int year, int pages) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.pages = pages;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getYear() { return year; }
    public int getPages() { return pages; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return year == book.year &&
                pages == book.pages &&
                Objects.equals(title, book.title) &&
                Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, year, pages);
    }

    @Override
    public String toString() {
        return title + ", автор: " + author + " (" + year + "), страниц: " + pages;
    }
}

class Student {
    private String name;
    private List<Book> books;

    public Student(String name, List<Book> books) {
        if (books.size() < 5) {
            throw new IllegalArgumentException("У студента должно быть не менее 5 книг");
        }
        this.name = name;
        this.books = new ArrayList<>(books);
    }

    public String getName() { return name; }
    public List<Book> getBooks() { return new ArrayList<>(books); }

    @Override
    public String toString() {
        return "Студент: " + name + "\nКниги:\n" +
                books.stream()
                        .map(Book::toString)
                        .collect(Collectors.joining("\n"));
    }
}

