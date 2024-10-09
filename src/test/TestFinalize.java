package test;

import lab1.Person;
import lab1.q3.Book;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class PersonTest {

    @Test
    void testCountIncrement() {

        Person p1 = new Person("Joshua", "Bloch", Person.Gender.M, 1234);
        Person p2 = new Person("Jane", "Doe", Person.Gender.F, 5678);

        assertEquals(2, Person.COUNT);
    }

}

class PersonBookEqualsTest {

    @Test
    public void testPersonEquals() {

        Person p1 = new Person("Joshua", "Bloch", Person.Gender.M, 1234);
        Person p2 = new Person("Joshua", "Bloch", Person.Gender.M, 1234);
        Person p3 = new Person("Joshua", "Bloch", Person.Gender.M, 12345);
        Person p4 = p1;

        assertTrue(p1.equals(p2), "p1 should be equal to p2");
        assertTrue(p4.equals(p1), "p4 should be equal to p1 (same reference)");
        assertFalse(p1.equals(p3), "p1 should not be equal to p3 (different SIN)");

        assertEquals(p1.hashCode(), p2.hashCode(), "p1 and p2 should have the same hashCode");
        assertNotEquals(p1.hashCode(), p3.hashCode(), "p1 and p3 should have different hashCodes");
    }

    @Test
    public void testBookEquals() {
        Person p1 = new Person("Joshua", "Bloch", Person.Gender.M, 1234);

        Book b1 = new Book("Effective Java", p1, "978-0134685991");
        Book b2 = new Book("Effective Java", p1, "978-0134685991");
        Book b3 = new Book("Effective Java", p1, "978-01346859910");
        Book b4 = b1;

        assertTrue(b1.equals(b2), "b1 should be equal to b2 (same title, author, and ISBN)");
        assertTrue(b4.equals(b1), "b4 should be equal to b1 (same reference)");
        assertFalse(b1.equals(b3), "b1 should not be equal to b3 (different ISBN)");

        assertEquals(b1.hashCode(), b2.hashCode(), "b1 and b2 should have the same hashCode");
        assertNotEquals(b1.hashCode(), b3.hashCode(), "b1 and b3 should have different hashCodes");
    }

    @Test
    public void testPersonEqualityOperator() {
        Person p1 = new Person("Joshua", "Bloch", Person.Gender.M, 1234);
        Person p2 = new Person("Joshua", "Bloch", Person.Gender.M, 1234);

        if (p1 == p2) {
            System.out.println("p1 == p2 evaluates to TRUE");
        } else {
            System.out.println("p1 == p2 evaluates to FALSE");
        }

        assertNotSame(p1, p2, "p1 and p2 are different objects, so == should return false");
    }
}
