import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calc {
    public static void main(String[] args) {

        try (Scanner in = new Scanner(System.in)) {
            String inputData = "";
            inputData = in.nextLine();
            inputData = inputData.toUpperCase();
            int arg01, arg02, res;

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
                // Получаем первое число из списка romansList и помещаем его в символьный массив
                // char[] arg01CharArray = romansList.get(0).toCharArray();
                // arg01 = numConverter(arg01CharArray); // Применяем к массиву функцию
                arg01 = numConverter(romansList, 0);
                arg02 = numConverter(romansList, 1);
                System.out.println(arg01 + " " + arg02);
                // преобразования в арабское число
                // Получаем второе число из списка romansList и помещаем его в символьный массив
                // char[] arg02CharArray = romansList.get(1).toCharArray();
                // arg02 = numConverter(arg01CharArray); // Применяем к массиву функцию
                // char[] output01 = numConverter(romansList, 0);
                // char[] output02 = numConverter(romansList, 1);
                //System.out.println(romansList);
                //System.out.println(romansList.get(0) + " " + romansList.get(1));
                // преобразования в арабское число
                // Дальше можно работать как с арабскими числами
                // System.out.println(output01[0] + output01[1] + " " + output02[0] +
                // output02[1]);
                // System.out.println(arg01CharArray[0] + " " + arg01CharArray[1]);

            } else {
                // Обработка арабских чисел
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
                System.out.println("Работаем с арабскими числами!");
                res = calculator(arg01, arg02, inputData);
                System.out.println(res);
            }
        } catch (

        Exception a) {
            a.printStackTrace();
        }

    }

    // ФУНКЦИЯ КОНВЕРТАЦИИ РИМСКИХ ЧИСЕЛ В АРАБСКИЕ
    public static int numConverter(List<String> inputString, int index) {
        int res = 0;
        char[] inputStringArray = inputString.get(index).toCharArray();
        //System.out.println(inputStringArray);
        //System.out.println("Длина массива: " + inputStringArray.length);
        // char valueOfEndSymbol = fromStrinIg[fromStrinIg.length - 1];
        // Создаем МАР
        HashMap<Character, Integer> romanMap = new HashMap<>();{
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);
        }
        if (inputString.size() == 1) {
            char valueOfEndSymbol = inputStringArray[inputStringArray.length-1];
            res = romanMap.get(valueOfEndSymbol);
        }
         else {
res = 2;
         }
        return res;
    }

    public static int calculator(int arg1, int arg2, String input) {
        int res = 0;
        if (input.contains("+")) { // Делаем сложение
            res = arg1 + arg2;
            System.out.println("Сумма чисел " + arg1 + " и " + arg2 + " равна " + res);
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
        return res;
    }
}