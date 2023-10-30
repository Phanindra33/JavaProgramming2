package com.example.internsavy_java_programming_project2;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Book {
    private int id;
    private String title;
    private String author;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}

public class BookCRUD {
    private static List<Book> books = new ArrayList<>();
    private static int nextId = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Create");
            System.out.println("2. Read");
            System.out.println("3. Update");
            System.out.println("4. Delete");
            System.out.println("5. Quit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    createBook(scanner);
                    break;
                case 2:
                    readBooks();
                    break;
                case 3:
                    updateBook(scanner);
                    break;
                case 4:
                    deleteBook(scanner);
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void createBook(Scanner scanner) {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();

        System.out.print("Enter author: ");
        String author = scanner.nextLine();

        Book book = new Book(nextId, title, author);
        books.add(book);
        nextId++;

        System.out.println("Book created successfully.");
    }

    private static void readBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
        } else {
            System.out.println("List of Books:");
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    private static void updateBook(Scanner scanner) {
        System.out.print("Enter the ID of the book to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        for (Book book : books) {
            if (book.getId() == id) {
                System.out.print("Enter new title: ");
                String newTitle = scanner.nextLine();
                book.setTitle(newTitle);

                System.out.print("Enter new author: ");
                String newAuthor = scanner.nextLine();
                book.setAuthor(newAuthor);

                System.out.println("Book updated successfully.");
                return;
            }
        }

        System.out.println("Book with ID " + id + " not found.");
    }

    private static void deleteBook(Scanner scanner) {
        System.out.print("Enter the ID of the book to delete: ");
        int id = scanner.nextInt();

        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getId() == id) {
                books.remove(i);
                System.out.println("Book deleted successfully.");
                return;
            }
        }

        System.out.println("Book with ID " + id + " not found.");
    }
}
