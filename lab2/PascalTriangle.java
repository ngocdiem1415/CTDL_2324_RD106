package lab2;

import java.util.Arrays;

public class PascalTriangle {

    public static void print(int row) {
        for (int i = 1; i <= row; i++) {
            printPascalTriangle(getPascalTriangle(i));
            System.out.println();
        }
    }
    public  static void printPascalTriangle(int[] row){
        for (int i = 0; i < row.length; i++) {
            System.out.print(row[i] +" ");
        }
    }

    public static int[] getPascalTriangle(int n) {
        if (n == 1) {
            return new int[]{1};
        } else {
            int[] preRow = getPascalTriangle(n - 1);
            return generateNextRow(preRow);
        }
    }

    //preRow (1) => { 1,1}
    public static int[] generateNextRow(int[] prevRow) {
        int n = prevRow.length;
        int[] result = new int[n + 1];
        result[0] = 1;
        result[n] = 1;
        for (int i = 1; i < n ; i++) {
            result[i] = prevRow[i - 1] + prevRow[i];
        }
        return result;
    }

    public static void main(String[] args) {
//       System.out.println(Arrays.toString(getPascalTriangle(5)));
        print(5);
//        print(generateNextRow(new int[]{1, 3,3,1}));
    }
}
