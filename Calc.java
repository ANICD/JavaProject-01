import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calc {
    public static void main(String[] args) {

        try (Scanner in = new Scanner(System.in)) {
            String inputData = "";
            inputData = in.nextLine();
            inputData = inputData.toUpperCase();
            int arg01, arg02;
            // if ((inputData.contains("I") || inputData.contains("V") ||
            // inputData.contains("X") && inputList.contains(regex:"[1-10]")))
            // throw new Exception("Оба числа должны быть или римские, или арабские");
            // Обработка римских чисел
            if (inputData.contains("I") || inputData.contains("V") || inputData.contains("X")) {
                System.out.println("Работаем с римскими числами!");
                // Выделяем римские числа из входного потока и помещаем их в List с именем
                // romanslist(строковый тип)
                List<String> romansList = new ArrayList<String>();
                Pattern p01 = Pattern.compile("[IVX]+", Pattern.CASE_INSENSITIVE);
                Matcher m01 = p01.matcher(inputData);
                while (m01.find()) {
                    romansList.add(m01.group());
                }
                // Определяем исключение на количество введенных чисел
                // (их должно быть не более двух)
                if (romansList.size() != 2)
                    throw new Exception("Небходимо ввести два аргумента!");
                arg01 = RomansConverter(romansList, 0);// Ищем первое число с помощью конвертера
                arg02 = RomansConverter(romansList, 1);// Ищем второе число с помощью конвертера
                if ((arg01 > 10) && (arg02 > 10))
                    throw new Exception("Неправильно введены оба числа! Числа должны быть от I до X");
                if (arg01 > 10)
                    throw new Exception("Неправильно введено первое число! Число должно быть от I до X");
                if (arg02 > 10)
                    throw new Exception("Неправильно введено второе число! Число должно быть от I до X");
                CalcRomansNumber(arg01, arg02, inputData, romansList); // Применяем процедуру вычисления
                // System.out.println(arg01 + " " + arg02);
            } else {
                // Обработка арабских чисел
                System.out.println("Работаем с арабскими числами!");
                List<String> arabiansList = new ArrayList<String>();
                Pattern p02 = Pattern.compile("\\d+");
                Matcher m02 = p02.matcher(inputData);
                while (m02.find()) {
                    arabiansList.add(m02.group());
                }
                if (arabiansList.size() != 2)
                    throw new Exception("Небходимо ввести два аргумента!");
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

    public static void CalcRomansNumber(int arg1, int arg2, String input, List<String> inputList) {
        int res = 0;
        if (input.contains("+")) { // Делаем сложение
            res = arg1 + arg2;
            System.out.println("Сумма чисел " + inputList.get(0) + " и " + inputList.get(1) + " равна " + res);
        } else if (input.contains("-")) { // Делаем вычитание
            res = arg1 - arg2;
            System.out.println("Разность чисел " + inputList.get(0) + " и " + inputList.get(1) + " равна " + res);
        } else if (input.contains("*")) { // Делаем умножение
            res = arg1 * arg2;
            System.out.println("Произведение чисел " + inputList.get(0) + " и " + inputList.get(1) + " равна " + res);
        } else if (input.contains("/")) { // Делаем деление
            res = arg1 / arg2;
            System.out.println("Частное чисел " + inputList.get(0) + " и " + inputList.get(1) + " равно " + res);
        }
    }

    public static void CalcArabNumber(int arg1, int arg2, String input) {
        int res = 0;
        if (input.contains("+")) { // Делаем сложение
            res = arg1 + arg2;
            System.out.println("Сумма чисел " + input + " и " + arg2 + " равна " + res);
        } else if (input.contains("-")) { // Делаем вычитание
            res = arg1 - arg2;
            System.out.println("Разность чисел " + arg1 + " и " + arg2 + " равна " + res);
        } else if (input.contains("*")) { // Делаем умножение
            res = arg1 * arg2;
            System.out.println("Произведение чисел " + arg1 + " и " + arg2 + " равна " + res);
        } else if (input.contains("/")) { // Делаем деление
            res = arg1 / arg2;
            System.out.println("Частное чисел " + arg1 + " и " + arg2 + " равно " + res);
        }
    }
}