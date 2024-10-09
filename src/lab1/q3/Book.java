package lab1.q3;

import lab1.Person;

import java.util.Objects;

public class Book {
    private String title;
    private final Person author;
    private String isbn13;
    private Person owner;

    public Book(String title, Person author, String isbn13) {
        this.title = title;
        this.author = author;
        this.isbn13 = isbn13;
    }

    public String getTitle() {
        return title;
    }

    public Person getAuthor() {
        return author;
    }

    public String getIsbn13() {
        return isbn13;
    }

    public Person getOwner() {
        return owner;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setIsbn13(String isbn13) {
        this.isbn13 = isbn13;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Book book = (Book) obj;

        return (Objects.equals(title, book.title)) &&
                (Objects.equals(author, book.author)) &&
                (Objects.equals(isbn13, book.isbn13));
    }

    @Override
    public int hashCode() {
        int result = (title != null ? title.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (isbn13 != null ? isbn13.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        String ownerInfo = (owner != null) ? ", Owner: " + owner.getFirstname() + " " + owner.getLastname() : " (unsold)";
        return "Title: " + title + ", Author: " + author.getFirstname() + " " + author.getLastname() + ", ISBN-13: " + isbn13 + ownerInfo;
    }
}
