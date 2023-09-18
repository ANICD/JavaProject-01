import java.util.ArrayList;
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
            inputData = inputData.toUpperCase();
            // Обработка римских чисел
            // =============================================================================
            if (inputData.contains("I") || inputData.contains("V") || inputData.contains("X")) {
                System.out.println("Работаем с римскими числами!");
                int arg01 = 0, arg02 = 0, res = 0;
                Map<Character, Integer> romanMap = new TreeMap<>();
                romanMap.put('I', 1);
                romanMap.put('V', 5);
                romanMap.put('X', 10);
                romanMap.put('L', 50);
                romanMap.put('C', 100);
                romanMap.put('D', 500);
                romanMap.put('M', 1000);
                List<String> romansList = new ArrayList<String>();
                Pattern p01 = Pattern.compile("[IVX]+", Pattern.CASE_INSENSITIVE);
                Matcher m01 = p01.matcher(inputData);
                while (m01.find()) {
                    romansList.add(m01.group());
                }
                int lenRomanList = romansList.size();
                if (lenRomanList != 2)
                    throw new Exception("Небходимо ввести два аргумента!");
                // ==============================================================
                char[] arg01CharArray = romansList.get(0).toCharArray();
                int charArr01Len = arg01CharArray.length - 1;
                int res01 = arg01CharArray[arg01CharArray.length];
                if (charArr01Len == 1)
                    arg01 = arg01CharArray[arg01CharArray.length];
                else {
                    for (int n = charArr01Len - 1; n >= 0; n--) {
                        int leftSymbol = romanMap.get(arg01CharArray[n]);
                        // int rightSymbol = romanMap.get(arg01CharArray[n + 1]);
                        if (leftSymbol <= res01)
                            res01 -= leftSymbol;
                        else
                            res01 += leftSymbol;
                        leftSymbol = res01;
                    }
                    arg01 = res01;
                    System.out.println(arg01);
                }
                // ================================================================
                char[] arg02CharArray = romansList.get(1).toCharArray();
                int charArr02Len = arg02CharArray.length - 1;
                int res02 = arg01CharArray[arg02CharArray.length];
                if (charArr02Len == 1)
                    arg02 = arg02CharArray[charArr02Len + 1];
                else {
                    for (int n = charArr02Len - 1; n >= 0; n--) {
                        int leftSymbol = romanMap.get(arg02CharArray[n]);
                        // int rightSymbol = romanMap.get(arg02CharArray[n + 1]);
                        if (leftSymbol <= res02)
                            res02 -= leftSymbol;
                        else
                            res02 += leftSymbol;
                        leftSymbol = res02;
                    }
                    arg02 = res02;
                    System.out.println(arg02);
                }
            } else {
                // Обработка арабских чисел
                // ============================================================================

                int arg01, arg02, res;
                List<String> arabiansList = new ArrayList<String>();
                Pattern p02 = Pattern.compile("\\d+");
                Matcher m02 = p02.matcher(inputData);
                while (m02.find()) {
                    arabiansList.add(m02.group());
                }
                int lenArabList = arabiansList.size();
                if (lenArabList != 2)
                    throw new Exception("Небходимо ввести два аргумента!");
                arg01 = Integer.parseInt(arabiansList.get(0));
                arg02 = Integer.parseInt(arabiansList.get(1));
                // Обработка арабских чисел
                if ((arg01 > 10) && (arg02 > 10))
                    throw new Exception("Неправильно введены оба числа! Числа должны быть от 1 до 10");
                if (arg01 > 10)
                    throw new Exception("Неправильно введено первое число! Число должно быть от 1 до 10");
                if (arg02 > 10)
                    throw new Exception("Неправильно введено второе число! Число должно быть от 1 до 10");
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