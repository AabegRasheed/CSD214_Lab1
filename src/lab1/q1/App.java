package lab1.q1;

import lab1.q3.Book;
import lab1.Person;
import java.util.Scanner;

public class App {

    private final int numBooks = 100;
    private final Book[] unsoldBooks = new Book[numBooks];
    private final Book[] soldBooks = new Book[numBooks];
    private int unsoldCurrentIndex = 0;
    private int soldCurrentIndex = 0;
    private final Scanner input = new Scanner(System.in);

    public void run() {
        boolean running = true;
        while (running) {
            String menu = "----------------\n"
                    + " 1. Add a Book\n"
                    + " 2. Edit a Book\n"
                    + " 3. Delete an unsold Book\n"
                    + " 4. Delete a sold Book\n"
                    + " 5. List unsold Books\n"
                    + " 6. List sold Books\n"
                    + " 7. Sell a Book\n"
                    + "99. Exit\n";
            System.out.println(menu);
            System.out.print("Enter your choice: ");
            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    editBook();
                    break;
                case 3:
                    deleteUnsoldBook();
                    break;
                case 4:
                    deleteSoldBook();
                    break;
                case 5:
                    listUnsoldBooks();
                    break;
                case 6:
                    listSoldBooks();
                    break;
                case 7:
                    sellBook();
                    break;
                case 99:
                    running = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
                    break;
            }
        }
    }

    private void addBook() {
        if (unsoldCurrentIndex >= numBooks) {
            System.out.println("Bookstore is full, cannot add more books.");
            return;
        }

        System.out.print("Enter title: ");
        String title = input.nextLine();
        System.out.print("Enter author first name: ");
        String firstName = input.nextLine();
        System.out.print("Enter author last name: ");
        String lastName = input.nextLine();
        System.out.print("Enter ISBN-13: ");
        String isbn = input.nextLine();

        Person author = new Person(firstName, lastName);
        Book newBook = new Book(title, author, isbn);

        unsoldBooks[unsoldCurrentIndex] = newBook;
        unsoldCurrentIndex++;

        System.out.println("Book added successfully!");
    }

    private void editBook() {
        listUnsoldBooks();
        System.out.print("Enter the number of the book to edit: ");
        int index = input.nextInt() - 1;
        input.nextLine();

        if (index >= 0 && index < unsoldCurrentIndex && unsoldBooks[index] != null) {
            System.out.print("Enter new title (leave blank to keep current): ");
            String newTitle = input.nextLine();
            System.out.print("Enter new ISBN-13 (leave blank to keep current): ");
            String newIsbn = input.nextLine();

            if (!newTitle.isEmpty()) {
                unsoldBooks[index].setTitle(newTitle);
            }
            if (!newIsbn.isEmpty()) {
                unsoldBooks[index].setIsbn13(newIsbn);
            }
            System.out.println("Book updated successfully!");
        } else {
            System.out.println("Invalid book number.");
        }
    }

    private void deleteUnsoldBook() {
        listUnsoldBooks();
        System.out.print("Enter the number of the book to delete: ");
        int index = input.nextInt() - 1;
        input.nextLine();

        if (index >= 0 && index < unsoldCurrentIndex && unsoldBooks[index] != null) {
            for (int i = index; i < unsoldCurrentIndex - 1; i++) {
                unsoldBooks[i] = unsoldBooks[i + 1];
            }
            unsoldBooks[--unsoldCurrentIndex] = null;
            System.out.println("Book deleted successfully!");
        } else {
            System.out.println("Invalid book number.");
        }
    }

    private void deleteSoldBook() {
        listSoldBooks();
        System.out.print("Enter the number of the sold book to delete: ");
        int index = input.nextInt() - 1;
        input.nextLine();

        if (index >= 0 && index < soldCurrentIndex && soldBooks[index] != null) {

            for (int i = index; i < soldCurrentIndex - 1; i++) {
                soldBooks[i] = soldBooks[i + 1];
            }
            soldBooks[--soldCurrentIndex] = null;
            System.out.println("Sold book deleted successfully!");
        } else {
            System.out.println("Invalid sold book number.");
        }
    }

    private void listUnsoldBooks() {
        System.out.println("Unsold Books:");
        for (int i = 0; i < unsoldCurrentIndex; i++) {
            System.out.println((i + 1) + ". " + unsoldBooks[i]);
        }
    }

    private void listSoldBooks() {
        System.out.println("Sold Books:");
        for (int i = 0; i < soldCurrentIndex; i++) {
            System.out.println((i + 1) + ". " + soldBooks[i]);
        }
    }

    private void sellBook() {
        listUnsoldBooks();
        System.out.print("Enter the number of the book to sell: ");
        int index = input.nextInt() - 1;
        input.nextLine();

        if (index >= 0 && index < unsoldCurrentIndex && unsoldBooks[index] != null) {
            System.out.print("Enter buyer first name: ");
            String firstName = input.nextLine();
            System.out.print("Enter buyer last name: ");
            String lastName = input.nextLine();

            Person buyer = new Person(firstName, lastName);
            unsoldBooks[index].setOwner(buyer);

            soldBooks[soldCurrentIndex++] = unsoldBooks[index];
            deleteUnsoldBookAtIndex(index);
            System.out.println("Book sold successfully!");
        } else {
            System.out.println("Invalid book number.");
        }
    }

    private void deleteUnsoldBookAtIndex(int index) {
        for (int i = index; i < unsoldCurrentIndex - 1; i++) {
            unsoldBooks[i] = unsoldBooks[i + 1];
        }
        unsoldBooks[--unsoldCurrentIndex] = null;
    }
    
    public static void main(String[] args) {
        new App().run();
    }
}
