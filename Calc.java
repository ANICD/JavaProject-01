import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calc {
    /**
     * @param args
     */
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.print("Введите выражение (арабские или римские числа): ");
            String inputData = "";
            inputData = in.nextLine();
            inputData = inputData.toUpperCase();
            int arg01, arg02;
            // Обработка римских чисел
            if (inputData.contains("I") || inputData.contains("V") || inputData.contains("X")) {
                List<String> romansList = new ArrayList<String>();
                Pattern p01 = Pattern.compile("[IVX]+", Pattern.CASE_INSENSITIVE);
                Matcher m01 = p01.matcher(inputData);
                while (m01.find()) {
                    romansList.add(m01.group());
                }
                if (romansList.size() != 2)
                    throw new Exception("Неверное выражение!");
                System.out.println("Работаем с римскими числами!");
                arg01 = RomansConverter(romansList, 0);// Ищем первое число с помощью конвертера
                arg02 = RomansConverter(romansList, 1);// Ищем второе число с помощью конвертера
                if ((arg01 > 10) && (arg02 > 10))
                    throw new Exception("Неправильно введены оба числа! Числа должны быть от I до X");
                if (arg01 > 10)
                    throw new Exception("Неправильно введено первое число! Число должно быть от I до X");
                if (arg02 > 10)
                    throw new Exception("Неправильно введено второе число! Число должно быть от I до X");
                CalcRomansNumber(arg01, arg02, inputData, romansList); // Применяем процедуру вычисления

            } else {
                // Обработка арабских чисел
                List<String> arabiansList = new ArrayList<String>();
                Pattern p02 = Pattern.compile("\\d+");
                Matcher m02 = p02.matcher(inputData);
                while (m02.find()) {
                    arabiansList.add(m02.group());
                }
                if (arabiansList.size() != 2)
                    throw new Exception("Неверное выражение!");
                System.out.println("Работаем с арабскими числами!");
                arg01 = Integer.parseInt(arabiansList.get(0));
                arg02 = Integer.parseInt(arabiansList.get(1));
                if ((arg01 > 10) && (arg02 > 10))
                    throw new Exception("Неправильно введены оба числа! Числа должны быть от 1 до 10");
                if (arg01 > 10)
                    throw new Exception("Неправильно введено первое число! Число должно быть от 1 до 10");
                if (arg02 > 10)
                    throw new Exception("Неправильно введено второе число! Число должно быть от 1 до 10");
                CalcArabNumber(arg01, arg02, inputData);
            }
        } catch (Exception a) {
            a.printStackTrace();
        }
    }

    // ФУНКЦИЯ КОНВЕРТАЦИИ РИМСКИХ ЧИСЕЛ В АРАБСКИЕ
    public static int RomansConverter(List<String> inputString, int index) {
        char[] inputStringArray = inputString.get(index).toCharArray(); // Преобразование List в массив
        // Создаем МАР
        HashMap<Character, Integer> romanMap = new HashMap<Character, Integer>();
        {
            romanMap.put('I', 1);
            romanMap.put('V', 5);
            romanMap.put('X', 10);
            romanMap.put('L', 50);
            romanMap.put('C', 100);
            romanMap.put('D', 500);
            romanMap.put('M', 1000);
        }
        int res = romanMap.get(inputStringArray[inputStringArray.length - 1]);
        if (inputStringArray.length == 1)
            res = romanMap.get(inputStringArray[inputStringArray.length - 1]);
        else {
            for (int n = inputStringArray.length - 2; n >= 0; n--) {
                int currSymbol = romanMap.get(inputStringArray[n]);
                int prevSymbol = romanMap.get(inputStringArray[n + 1]);
                if (currSymbol < prevSymbol) {
                    res -= currSymbol;
                } else {
                    res += currSymbol;
                }
            }
        }
        return res;
    }

    // ФУНКЦИЯ КОНВЕРТАЦИИ АРАБСКИХ ЧИСЕЛ В РИМСКИЕ
    public static String ArabConverter(int arabianResult) {
        String stringResult = "";
        // Создаем МАР
        LinkedHashMap<String, Integer> arabMap = new LinkedHashMap<String, Integer>();
        {
            arabMap.put("M", 1000);
            arabMap.put("CM", 900);
            arabMap.put("D", 500);
            arabMap.put("CD", 400);
            arabMap.put("C", 100);
            arabMap.put("XC", 90);
            arabMap.put("L", 50);
            arabMap.put("XL", 40);
            arabMap.put("X", 10);
            arabMap.put("IX", 9);
            arabMap.put("V", 5);
            arabMap.put("IV", 4);
            arabMap.put("I", 1);
        }
        for (Map.Entry<String, Integer> entry : arabMap.entrySet()) {
            int matches = arabianResult / entry.getValue();
            stringResult += repeat(entry.getKey(), matches);
            arabianResult = arabianResult % entry.getValue();
        }
        return stringResult;
    }

    public static String repeat(String s, int n) {
        if (s == null) {
            return null;
        }
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(s);
        }
        return sb.toString();
    }

    public static int CalcRomansNumber(int arg1, int arg2, String input, List<String> inputList) {
        int res = 0;
        if (input.contains("+")) { // Делаем сложение
            res = arg1 + arg2;
            System.out.println(
                    "Сумма чисел " + inputList.get(0) + " и " + inputList.get(1) + " равна " + ArabConverter(res));
        } else if (input.contains("-")) { // Делаем вычитание
            res = arg1 - arg2;
            System.out.println(
                    "Разность чисел " + inputList.get(0) + " и " + inputList.get(1) + " равна " + ArabConverter(res));
        } else if (input.contains("*")) { // Делаем умножение
            res = arg1 * arg2;
            System.out.println("Произведение чисел " + inputList.get(0) + " и " + inputList.get(1) + " равно "
                    + ArabConverter(res));
        } else if (input.contains("/")) { // Делаем деление
            res = arg1 / arg2;
            System.out.println(
                    "Частное чисел " + inputList.get(0) + " и " + inputList.get(1) + " равно " + ArabConverter(res));
        }
        return res;
    }

    public static void CalcArabNumber(int arg1, int arg2, String input) {
        int res = 0;
        if (input.contains("+")) { // Делаем сложение
            res = arg1 + arg2;
            System.out.println("Сумма чисел " + arg1 + " и " + arg2 + " равна " + res);
        } else if (input.contains("-")) { // Делаем вычитание
            res = arg1 - arg2;
            System.out.println("Разность чисел " + arg1 + " и " + arg2 + " равна " + res);
        } else if (input.contains("*")) { // Делаем умножение
            res = arg1 * arg2;
            System.out.println("Произведение чисел " + arg1 + " и " + arg2 + " равно " + res);
        } else if (input.contains("/")) { // Делаем деление
            res = arg1 / arg2;
            System.out.println("Частное чисел " + arg1 + " и " + arg2 + " равно " + res);
        }
    }

}