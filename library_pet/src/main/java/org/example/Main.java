package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<User> users = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nВыберите действие:");
            System.out.println("1 - Регистрация");
            System.out.println("2 - Вход");
            System.out.println("0 - Выход");

            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                register(scanner);
            } else if (choice.equals("2")) {
                login(scanner);
            } else if (choice.equals("0")) {
                System.out.println("До свидания!");
                break;
            } else {
                System.out.println("Неверный ввод. Попробуйте снова.");
            }
        }
    }

    public static void register(Scanner scanner) {
        System.out.print("Введите имя: ");
        String name = scanner.nextLine();

        System.out.print("Введите email: ");
        String email = scanner.nextLine();

        if (isEmailUsed(email)) {
            System.out.println("Такой email уже зарегистрирован.");
            return;
        }

        System.out.print("Введите пароль (не меньше 6 символов): ");
        String password = scanner.nextLine();

        if (password.length() < 6) {
            System.out.println("Пароль слишком короткий.");
            return;
        }

        System.out.print("Введите никнейм: ");
        String username = scanner.nextLine();

        User user = new User(name, password, email, username);
        users.add(user);

        System.out.println("Регистрация прошла успешно!");
    }

    public static void login(Scanner scanner) {
        System.out.print("Введите email: ");
        String email = scanner.nextLine();

        System.out.print("Введите пароль: ");
        String password = scanner.nextLine();

        for (User u : users) {
            if (u.getEmail().equalsIgnoreCase(email) && u.getPassword().equals(password)) {
                System.out.println("Добро пожаловать, " + u.getName() + "!");
                return;
            }
        }

        System.out.println("Неверный email или пароль.");
    }

    public static boolean isEmailUsed(String email) {
        for (User u : users) {
            if (u.getEmail().equalsIgnoreCase(email)) {
                return true;
            }
        }
        return false;
    }
}
class User {
    private String name;
    private String password;
    private String email;
    private String username;

    public User(String name, String password, String email, String username) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void displayInfo() {
        System.out.println("Имя: " + name);
        System.out.println("Email: " + email);
        System.out.println("Никнейм: " + username);
    }
}
