package com.cursor.hibernate.repository;

import com.cursor.hibernate.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Scanner;

@Repository
public class UserRepository {

    Scanner scanner = new Scanner(System.in);

    @PersistenceContext
    private EntityManager entityManager;

    public User findById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Transactional
    public void save() {
        System.out.println("Enter your name");
        String inputUserName = scanner.next();

        System.out.println("Enter your lastname");
        String inputUserLastname = scanner.next();

        System.out.println("Enter your age");
        int inputUserAge = scanner.nextInt();

        System.out.println("Enter your gender");
        String inputUserGender = scanner.next();

        entityManager.persist(new User(inputUserName, inputUserLastname, inputUserAge, inputUserGender));
    }

    @Transactional
    public void update() {

        System.out.println("Enter user id what you want to update".toUpperCase());
        Long userId = scanner.nextLong();

        User user = findById(userId);
        if (user == null) {
            System.out.println("User not found");
            System.exit(0);
        } else {
            System.out.println("Enter new user name");
            String inputNEWUserName = scanner.next();

            System.out.println("Enter new user lastname");
            String inputNEWUserLastname = scanner.next();

            System.out.println("Enter new user age");
            int inputNEWUserAge = scanner.nextInt();

            System.out.println("Enter new user gender");
            String inputNEWUserGender = scanner.next();

            entityManager.merge(new User(userId, inputNEWUserName, inputNEWUserLastname, inputNEWUserAge, inputNEWUserGender));
        }
    }

    @Transactional
    public List<User> getAll() {
        Query selectAll = entityManager.createQuery("SELECT u FROM User u");
        return selectAll.getResultList();
    }

    @Transactional
    public void getById() {
        System.out.println("Enter user id what you want to watch".toUpperCase());
        Long userId = scanner.nextLong();

        User user = findById(userId);
        if (user == null) {
            System.out.println("User not found");
        } else {
            System.out.println(user);
        }
    }

    @Transactional
    public void delete() {
        System.out.println("Enter user id what you want to delete".toUpperCase());
        Long userId = scanner.nextLong();
        User user = findById(userId);
        if (user == null) {
            System.out.println("User not found");
        } else {
            entityManager.remove(user);
            System.out.println("User deleted");
        }
    }
}