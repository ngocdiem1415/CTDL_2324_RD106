package lab2;

public class Task1_1 {
    // n >0
    public static int getSn1(int n) {
        if (n == 1) return 1;
        else return (int) (getSn1(n - 1) + Math.pow(-1, n + 1) * n);
    }
    //n>

    public static int giaiThua(int n) {
        if (n == 1) return 1;
        else return n * giaiThua(n - 1);
    }

    public static int getSn2(int n) {
        if (n == 1) return 1;
        else {
            return (n * giaiThua(n - 1) + getSn2(n - 1));
        }
    }

    //n>0
    public static int getSn3(int n) {
        int result =0;
        if (n == 1) return 1;
        return n * n + getSn3(n-1);
    }


    //n>=0 f(3) = 2.4.6
    public static int findTheDenominator(int n) {
        if (n == 1) return 2;
        else
            return 2 * n * findTheDenominator(n - 1);
    }

    public static double getSn4(int n) {
        if (n == 0) {
            return 1;
        } else {
            return (1 / (double)findTheDenominator(n) + getSn4(n - 1));
        }
//        return 0;
    }

    public static void main(String[] args) {
//        System.out.println(getSn1(4));
//        System.out.println(getSn2(4));
//        System.out.println(findTheDenominator(3));
        System.out.println(getSn3(2));
//        System.out.println(getSn4(10));
    }
}
