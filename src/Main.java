import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student("Марина", List.of(
                        new Book("Книга1", "Автор1", 2001, 300),
                        new Book("Книга2", "Автор2", 1999, 250),
                        new Book("Книга3", "Автор3", 2005, 400),
                        new Book("Книга4", "Автор4", 2010, 350),
                        new Book("Книга5", "Автор5", 1995, 200),
                        new Book("Книга6", "Автор6", 2003, 500)
                )),
                new Student("Андрей", List.of(
                        new Book("Книга7", "Автор7", 2002, 450),
                        new Book("Книга8", "Автор8", 1998, 300),
                        new Book("Книга3", "Автор3", 2005, 400),
                        new Book("Книга9", "Автор9", 2015, 600),
                        new Book("Книга10", "Автор10", 2008, 350),
                        new Book("Книга11", "Автор11", 2001, 400)
                )),
                new Student("Олег", List.of(
                        new Book("Книга12", "Автор12", 2004, 500),
                        new Book("Книга13", "Автор13", 1997, 250),
                        new Book("Книга14", "Автор14", 2012, 700),
                        new Book("Книга15", "Автор15", 2009, 450),
                        new Book("Книга16", "Автор16", 2003, 300),
                        new Book("Книга17", "Автор17", 2006, 550)
                ))
        );

        students.stream()
                .peek(System.out::println)
                .flatMap(student -> student.getBooks().stream())
                .distinct()
                .sorted(Comparator.comparingInt(Book::getPages))
                .filter(book -> book.getYear() > 2000)
                .limit(3)
                .map(Book::getYear)
                .findFirst()
                .ifPresentOrElse(
                        year -> System.out.println("\nГод выпуска найденной книги: " + year),
                        () -> System.out.println("\nКнига не найдена")
                );
    }
}