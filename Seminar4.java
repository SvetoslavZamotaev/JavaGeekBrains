import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Seminar4 {
    public static void main(String[] args) throws Exception {
        int row = 7;
        int col = 7;
        int map[][] = new int[row][col];
        for (int i = 0; i < row; i++) { // Через цикл создаю внешние стены из 1 для карты
            map[i][0] = 1;
            map[i][col - 1] = 1;
            for (int j = 0; j < col; j++) {
                map[0][j] = 1;
                map[row - 1][j] = 1;
            }
        }
        map[2][2] = 1; // добавляю стены
        map[3][2] = 1;
        map[4][2] = 1;
        map[4][3] = 1;
        map[2][1] = 2; // <-стартовая координата
        // map[5][5] - точка выхода
        int marker = 2; // переменная чтобы найти тот стартовый элемент в массиве и начать с него
                        // распространение
        do {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (map[i][j] == marker) {
                        MarkAround(map, i, j, marker);
                    }
                }
            }
            marker++;
        } while (map[5][5] == 0 || isFullArr(map, row, col));

        printMap(map); // карта с путём

        Queue<Integer> dataStack = new LinkedList<Integer>(); // "стек" координат
        int line = 5;
        int column = 5;
        while (map[2][1] != 0) {
            Backtohome(map, line, column, dataStack);
            line = dataStack.remove();
            column = dataStack.remove();
        }
        System.out.println("map with path zero's ");
        printMap(map); // принтую карту где путь указан нулями
    }

    public static void printMap(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; (array[i] != null && j < array[i].length); j++) {
                System.out.print(array[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public static Boolean isFullArr(int[][] arr, int row, int col) {
        Boolean isZero = true;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (arr[i][j] == 0) {
                    isZero = false;
                }
            }
        }
        return isZero;

    }

    public static void MarkAround(int[][] map, int row, int col, int counter) {

        if (map[row - 1][col] == 0) {
            map[row - 1][col] = counter + 1;
        }
        if (map[row][col + 1] == 0) {
            map[row][col + 1] = counter + 1;
        }
        if (map[row + 1][col] == 0) {
            map[row + 1][col] = counter + 1;
        }
        if (map[row][col - 1] == 0) {
            map[row][col - 1] = counter + 1;
        }
    }

    public static void Backtohome(int[][] arr, int line, int column, Queue<Integer> stack) {
        if (arr[line][column] == arr[line - 1][column] + 1) {
            stack.add(line - 1);
            stack.add(column);
            arr[line][column] = 0;
        }
        if (arr[line][column] == arr[line][column + 1] + 1) {
            stack.add(line);
            stack.add(column + 1);
            arr[line][column] = 0;
        }
        if (arr[line][column] == arr[line + 1][column] + 1) {
            stack.add(line + 1);
            stack.add(column);
            arr[line][column] = 0;
        }
        if (arr[line][column] == arr[line][column - 1] + 1) {
            stack.add(line);
            stack.add(column - 1);
            arr[line][column] = 0;
        }
    }

}
