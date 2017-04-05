package ua.com.codespace.jpaexample;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("h2-persistence-unit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(new Book("Harry Potter", "G.K.Rowling"));
        entityManager.persist(new Book("The Great Gatsby", "F. Scott Fitzgerald"));

        Book book = entityManager.find(Book.class, 1);
        System.out.println(book);

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}
