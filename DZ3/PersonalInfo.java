package com.example.DZ3;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*
Напишите приложение, которое будет запрашивать у пользователя следующие данные в произвольном порядке,
разделенные пробелом: Фамилия Имя Отчество дата рождения номертелефона пол
        Форматы данных:
        фамилия, имя, отчество - строки
        датарождения - строка формата dd.mm.yyyy
        номертелефона - целое беззнаковое число без форматирования
        пол - символ латиницей f или m.
Приложение должно проверить введенные данные по количеству. Если количество не совпадает с требуемым,
вернуть код ошибки, обработать его и показать пользователю сообщение, что он ввел меньше и больше данных,
чем требуется.
Приложение должно попытаться распарсить полученные значения и выделить из них требуемые параметры.
Если форматы данных не совпадают, нужно бросить исключение, соответствующее типу проблемы.
Можно использовать встроенные типы java и создать свои. Исключение должно быть корректно обработано,
пользователю выведено сообщение с информацией, что именно неверно.
Если всё введено и обработано верно, должен создаться файл с названием, равным фамилии,
в него в одну строку должны записаться полученные данные, вида
    <Фамилия><Имя><Отчество><датарождения> <номертелефона><пол>
Однофамильцы должны записаться в один и тот же файл, в отдельные строки.
Не забудьте закрыть соединение с файлом.
*/
public class PersonalInfo {
    public static void main(String[] args) {
        input_info();
    }

    /***
     * функция запроса ввода от пользователя
     */
    private static void input_info() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ввведите свои данные через пробел:\n" +
                "Фамилия Имя Отчество \n" +
                "Дата_рождения (dd.mm.yyyy)\n" +
                "Номер_телефона (NNNNNNNNNN)\n" +
                "пол (f / m): ");
        String str = scanner.nextLine();
        String[] arr_info = str.split(" ");
        if (arr_info.length<6) {
            except(1,"");
        } else if (arr_info.length>6) {
            except(2, "");
        } else {
            if (checkIfStringContainsDigit(arr_info[0]+arr_info[1]+arr_info[2])) {
                except(3, arr_info[0]+" "+arr_info[1]+" "+arr_info[2]);
            } else if (!arr_info[3].matches("(0[0-9]|1[0-9]|2[0-9]|3[0-1])[.](0[0-9]|1[0-2])[.]([1-2][0-9][0-9][0-9])")) {
                    except(4, arr_info[3]);
            } else if ((!arr_info[4].matches("\\d+")) || (arr_info[4].length() != 10)) {
                except(5, arr_info[4]);
            } else if ((!arr_info[5].equals("f")) && (!arr_info[5].equals("m"))) {
                except(6, arr_info[5]);
            } else {
                System.out.println("все круто");
                save(arr_info);
            }
        }
    }

    /**
     * функция вывода кода ошибки с пояснениями
     * @param error_code код ошибки
     * @param inf строка, содержащая ошибку
     */
    private static void except(int error_code, String inf) {
        String error_text = "Ошибка ввода данных (код "+error_code+"): ";
        try {
            switch (error_code) {
                case 1:
                    throw new ArithmeticException(error_text+"введены не все данные. Попробуйте заново");
                case 2:
                    throw new ArithmeticException(error_text+"введено больше данных, чем запрашивалось. Попробуйте заново");
                case 3:
                    throw new NumberFormatException(error_text+"неверный формат ФИО "+inf+". Не может содержать числа. Попробуйте заново");
                case 4:
                    throw new IllegalArgumentException(error_text+"неверное значение даты "+inf+". Должен быть dd.mm.yyyy. Попробуйте заново");
                case 5:
                    throw new NumberFormatException(error_text+"неверный формат телефона "+inf+". Должен быть только из деcяти цифр. Попробуйте заново");
                case 6:
                    throw new IllegalArgumentException(error_text+"неверный формат пола "+inf+". Должен быть f или m. Попробуйте заново");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        input_info();
    }

    /**
     * функция проверки, есть ли в строке цифры
     * @param passCode - переданна строка для проверки
     * @return true/false
     */
    private static boolean checkIfStringContainsDigit(String passCode){
        for (int i = 0; i < passCode.length(); i++) {
            if(Character.isDigit(passCode.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    /**
     * функция записи строки в файл
     * @param str
     */
    private static void save(String[] str) {
        try(FileWriter fileWriter = new FileWriter(str[0], true)) {
            String itog_str = "";
            for (int i = 0; i < str.length; i++) {
                itog_str += "<"+str[i]+">";
            }
            fileWriter.write(itog_str+"\n");
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
