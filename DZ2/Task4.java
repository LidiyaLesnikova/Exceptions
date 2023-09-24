package com.example.DZ2;

import java.util.Scanner;

public class Task4 {
    // Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку.
    // Пользователю должно показаться сообщение, что пустые строки вводить нельзя.
    public static void main(String[] args) {
        input_str();
    }

    private static void input_str() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ввведите строку: ");
        String str = scanner.nextLine();
        if (str.trim().isEmpty()) {
            try {
                throw new NullPointerException("Ошибка ввода данных, строка не может быть пустой. Попробуйте заново");
            } catch (NullPointerException e) {
                System.out.println(e.getMessage());
                input_str();
            }
        }
    }


}
