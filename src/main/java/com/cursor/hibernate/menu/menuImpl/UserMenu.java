package com.cursor.hibernate.menu.menuImpl;

import com.cursor.hibernate.menu.Menu;
import com.cursor.hibernate.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Scanner;

import static com.cursor.hibernate.menu.ConstantsMenu.*;

@Repository

public class UserMenu implements Menu {
    private final String[] items = {"""
          1. Create user
          --------------
          2. Update user
          --------------
          3. Delete user
          --------------
          4. Show user info
          --------------
          5. Show all users
          --------------
          0. Exit
          --------------
          """};
    boolean isRunning = true;
    @Autowired
    private UserRepository userRepository;

    @Override
    public void showMenu() {
        System.out.println("WELCOME!");
        showItems(items);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the menu number".toUpperCase());

        while (isRunning) {
            int choice = scanner.nextInt();

            if (CREATE_USER == choice) {
                userRepository.save();
            } else if (UPDATE_USER == choice) {
                userRepository.update();
            } else if (DELETE_USER == choice) {
                userRepository.delete();
            } else if (SHOW_USER_INFO == choice) {
                userRepository.getById();
            } else if (SHOW_ALL_USERS == choice) {
                userRepository.getAll().forEach(System.out::println);
            } else if (EXIT == choice) {
                exit();
            } else {
                System.out.println("WRONG POINT");
                showMenu();
            }
        }
    }

    @Override
    public void exit() {
        System.out.println("You exited.".toUpperCase());
        System.exit(0);
    }
}