package com.example.DZ2;

import java.util.Arrays;

public class Task2 {
    // исправьте данный код

    public static void main(String[] args) {
        int[] intArray = createArray();
        try {
            int d = 0;
            Double catchedRes1 = (double) intArray[8] / d;
            if (catchedRes1.isInfinite()) {
                System.out.println("Деление на 0 нельзя");
            } else if (catchedRes1.isNaN()) {
                System.out.println("Делимое и делитель оба числа равны нулю");
            } else {
                System.out.println("catchedRes1 = " + catchedRes1);
            }
        } catch (ArithmeticException | ArrayIndexOutOfBoundsException | NullPointerException e) {
            System.out.println("Catching exception: " + e);
        }
    }

    private static int[] createArray() {
        int lenght = (int) Math.round(Math.random()*15);
        System.out.println(lenght);
        int[] intArray = new int[lenght];
        for (int i = 0; i < lenght; i++) {
            intArray[i] = (int) Math.round(Math.random()*15);
        }
        System.out.println(Arrays.toString(intArray));
        return intArray;
    }
}
