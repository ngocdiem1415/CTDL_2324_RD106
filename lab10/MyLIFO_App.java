package lab10;

import java.sql.Array;
import java.util.*;

public class MyLIFO_App {
    public static <E> void stutter (Queue<E> input){
        Queue result = new ArrayDeque();
        while ( ! input.isEmpty()){
            result.add(input.peek());
            result.add(input.poll());
        }
        while ( !result.isEmpty()){
            System.out.print(result.poll() + " ");
        }
    }

    public static <E> void mirror (Queue<E> input){
        Stack temp = new Stack();
        temp.addAll(input);
        while ( ! temp.isEmpty()){
            input.add((E) temp.pop());
        }
        while ( ! input.isEmpty()) {
            System.out.print(input.poll() +" ");
        }
    }

    public static void main(String[] args) {
        Queue<Integer> test = new ArrayDeque<>();
        test.offer(4);
        test.offer(9);
        test.offer(1);
        test.offer(3);
//        stutter(test);
        mirror(test);
    }

}
