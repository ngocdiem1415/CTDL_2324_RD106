package lab2;

public class Fibonacci {

    public static int getFibonacci( int n){
        if ( n == 0) return 0;
        else if ( n ==1) return 1;
        else{
            int result =getFibonacci(n-2) + getFibonacci(n-1);
//            System.out.println(result);
           return result;
        }
    }

    public static void printFibinacci ( int n){
        for ( int i =0; i <=n ; i ++) {
            System.out.print(getFibonacci(i) + " ");
        }
    }

    public static void main(String[] args) {
        printFibinacci(10);
//        System.out.println(getFibonacci(4));
    }
}
