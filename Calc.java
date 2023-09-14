import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calc {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            String inputData = "";
            int arg01, arg02, res;
            inputData = in.nextLine(); // Ввод данных
            // Обработка введенной строки
            List<String> matchesList = new ArrayList<String>();
            Pattern p01 = Pattern.compile("\\d+");
            Matcher m01 = p01.matcher(inputData);
            while (m01.find()) {
                matchesList.add(m01.group());

                // System.out.println(matchesList.get(1));
            }
            arg01 = Integer.parseInt(matchesList.get(0));
            arg02 = Integer.parseInt(matchesList.get(1));

            if (inputData.contains("I") || inputData.contains("V") || inputData.contains("X")) {
                // Обработка римских чисел

                System.out.println("Работаем с римскими числами!");
            } else {
                if (arg01 <= 1 && arg01 > 10) 
                    System.out.println("Неправильно введено первое число! Число должно быть от 1 до 10");
                else if (arg02 <= 1 && arg02 > 10)
                    System.out.println("Неправильно введено второе число! Число должно быть от 1 до 10");
                else if ((arg01 <= 1 && arg01 > 10) && (arg02 <= 1 && arg02 > 10))
                    System.out.println("Неправильно введены оба числа! Числа должны быть от 1 до 10");
                else {
                    // Обработка арабских чисел
                    System.out.println("Работаем с арабскими числами!");
                    if (inputData.contains("+")) { // Делаем сложение
                        res = arg01 + arg02;
                        System.out.println("Сумма чисел " + arg01 + " и " + arg02 + " равна " + res);
                    } else if (inputData.contains("-")) { // Делаем вычитание
                        res = arg01 - arg02;
                        System.out.println("Разность чисел " + arg01 + " и " + arg02 + " равна " + res);
                    } else if (inputData.contains("*")) { // Делаем умножение
                        res = arg01 * arg02;
                        System.out.println("Произведение чисел " + arg01 + " и " + arg02 + " равна " + res);
                    } else if (inputData.contains("/")) { // Делаем деление
                        res = arg01 / arg02;
                        System.out.println("Частное чисел " + arg01 + " и " + arg02 + " равно " + res);
                    }
                }

            }
        } catch (Exception a) {
            a.printStackTrace();
        }

    }
}