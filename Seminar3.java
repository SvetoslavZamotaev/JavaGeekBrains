import java.util.Arrays;

public class Seminar3 {
    public static void main(String[] args) throws Exception {
        int n = 5;
        int m = 5;
        int[][] arr = new int[n][m];
        int i;
        int j;

        for (j = 0; j < m; j++) {
            arr[0][j] = 1;
        }
        for (i = 1; i < n; i++) {
            arr[i][0] = 1;
            for (j = 1; j < m; j++) {
                arr[i][j] = arr[i][j - 1] + arr[i - 1][j];
            }
        }
        printArr(arr);

    }

    public static void printArr(int[][] array) {
        for (int[] p : array) {
            System.out.println(Arrays.toString(p));
        }
    }
}
