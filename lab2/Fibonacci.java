package lab2;

public class Fibonacci {

    public static int getFibonacci( int n){
        if ( n== 0) return 0;
        else if ( n ==1) return  1;
        else{
           return  getFibonacci(n-2) + getFibonacci(n-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(getFibonacci(1));
    }
}
