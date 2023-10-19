package lab4;

public class lab5 {

    public static void printMaxtrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    //task1.1
    public static int[][] add(int[][] a, int[][] b) throws Exception {
        if (a.length != b.length) {
            throw new Exception("2 ma tran khac kich thuoc !");
        } else {
            int[][] result = new int[a.length][b.length];
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < a.length; j++) {
                    result[i][j] = a[i][j] + b[i][j];
                }
            }
            return result;
        }
    }

    //task1.2
    public static int[][] subTract(int[][] a, int[][] b) throws Exception {
        if (a.length != b.length) {
            throw new Exception("2 ma tran khac kich thuoc !");
        } else {
            int[][] result = new int[a.length][b.length];
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < a.length; j++) {
                    result[i][j] = a[i][j] - b[i][j];
                }
            }
            return result;
        }
    }

    public static int[][] multiply(int[][] a, int[][] b) {
        if (a[0].length != b.length) return null;
        int[][] result = new int[a.length][b[0].length];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                for (int k = 0; k < a[i].length; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        int[][] a = new int[][]{{7, 2,5,8}, {5,3,9, 3}};
        int[][] b = new int[][]{{2, 1,2}, {3, 1,4}, {5,4,3}, {2,8,9}};
        printMaxtrix(multiply( a, b));
//        System.out.println(a.length);
    }
}
