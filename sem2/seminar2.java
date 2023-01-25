import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;

public class seminar2 {
    public static void main(String[] args) throws Exception {
        FileWriter resFile = new FileWriter("outputs.txt", true);
        BufferedReader buf = new BufferedReader(new FileReader("inputs.txt"));
        String line;
        String nextLine;

        while ((line = buf.readLine()) != null) {
            nextLine = buf.readLine();
            if (line.charAt(0) == 'a') {
                resFile.write(degreeOfNum(editString(line), editString(nextLine)) + "\n");
            } else {
                resFile.write(degreeOfNum(editString(nextLine), editString(line)) + "\n");
            }
        }
        buf.close();
        resFile.close();
    }

    // метод для возведения 'а' в степень 'b'
    public static String degreeOfNum(String num, String degree) {
        Double a = Double.valueOf(num);
        Double b = Double.valueOf(degree);
        Double res = Math.pow(a, b);
        String result = String.valueOf(res);
        return result;
    }

    // метод для извлечения из строки фаила нужную цифру
    public static String editString(String lineFromFile) {
        String[] editingArr = lineFromFile.split(" ");
        return editingArr[1];
    }
}
