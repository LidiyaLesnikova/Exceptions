package com.example.DZ2;

import java.util.Scanner;

public class Task1 {
    // Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float),
    // и возвращает введенное значение. Ввод текста вместо числа не должно приводить к падению приложения,
    // вместо этого, необходимо повторно запросить у пользователя ввод данных.
    public static void main(String[] args) {
        System.out.println("Введено число " + input_float_number());
    }

    private static float input_float_number(){
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Ввведите дробное число: ");
            float a = scanner.nextFloat();
            return a;
        } catch (Exception e) {
            System.out.println("Ошибка ввода типа данных: " + e.getMessage() + ". Попробуйте снова");
        }
        return input_float_number();
    }
}
