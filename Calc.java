import java.util.Scanner;

public class Calc {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            String inputData = "";
            int lInputString = 0;
            inputData = in.nextLine(); // Ввод данных
            lInputString = inputData.length(); // Длина введенной строки
            // Обработка введенной строки
            //System.out.println(inputData);
            //System.out.println(lInputString);
        } catch (Exception a) {
            a.printStackTrace();
        }

    }
}