import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calc {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            String inputData = "";
            inputData = in.nextLine();
            int l = inputData.length();
            // Обработка римских чисел=============================================================================
            if (inputData.contains("I") || inputData.contains("V") || inputData.contains("X")) {
                System.out.println("Работаем с римскими числами!");
                int start = 0;
                char [] inputChar = new char[l - start];
                inputData.getChars(start, l, inputChar, 0);
                System.out.println(inputChar);
                
                
               /* int arabian;
                Map<Character, Integer> rMap = new HashMap<>();
                rMap.put('I', 1);
                rMap.put('V', 5);
                rMap.put('X', 10);
                rMap.put('L', 50);
                rMap.put('C', 100);
                rMap.put('D', 500);
                rMap.put('M', 1000);
                for (int n = l - 1; n >= 0; n--) {
                    arabian = rMap.get(n)
                }*/
            } else {
                // Обработка арабских чисел============================================================================
                int arg01, arg02, res;
                List<String> matchesList = new ArrayList<String>();
                Pattern p01 = Pattern.compile("\\d+");
                Matcher m01 = p01.matcher(inputData);
                while (m01.find()) {
                    matchesList.add(m01.group());
                }
                arg01 = Integer.parseInt(matchesList.get(0));
                arg02 = Integer.parseInt(matchesList.get(1));
                // Обработка арабских чисел
                if ((arg01 > 10) && (arg02 > 10)) {
                    System.out.println("Неправильно введены оба числа! Числа должны быть от 1 до 10");
                    return;
                } else if (arg01 > 10) {
                    System.out.println("Неправильно введено первое число! Число должно быть от 1 до 10");
                    return;
                } else if (arg02 > 10) {
                    System.out.println("Неправильно введено второе число! Число должно быть от 1 до 10");
                    return;
                }
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
        } catch (

        Exception a) {
            a.printStackTrace();
        }

    }
}