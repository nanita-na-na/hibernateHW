package com.cursor.hibernate;

import com.cursor.hibernate.menu.menuImpl.UserMenu;
import com.cursor.hibernate.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class HibernateApplication implements CommandLineRunner {

    @Autowired
    private UserMenu userMenu;

    public static void main(String[] args) {
        SpringApplication.run(HibernateApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        userMenu.showMenu();
    }
}
