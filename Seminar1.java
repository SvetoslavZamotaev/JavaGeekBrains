import java.util.Scanner;
import java.io.IOException;
import java.io.PrintStream;
import static java.nio.charset.StandardCharsets.UTF_8;

public class Seminar1 {

    public static void main(String[] args) {
        PrintStream out = new PrintStream(System.out, true, UTF_8);
        Scanner iScanner = new Scanner(System.in);
        out.println("Введите порядковый номер числа из ряда треугольных чисел  :");
        int input = iScanner.nextInt();
        iScanner.close();
        int triangleNum = (input * (input + 1)) / 2;
        out.printf("Ответ : %s ", triangleNum);

    }
}