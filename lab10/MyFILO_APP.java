package lab10;

import java.io.BufferedReader;
import java.io.StreamTokenizer;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class MyFILO_APP {

    public static <E> void reserve(E[] array) {
        Stack temp = new Stack();
        if (array.length <= 0) {
            System.out.println(" ");
        } else {
            temp.addAll(List.of(array));
        }
        while (!temp.isEmpty()) {
            System.out.print(temp.pop() + " ");
        }
    }

    public static boolean isCorrect(String input) {
        Stack<Character> temp = new Stack();
        outer:
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch == '{' || ch == '[' || ch == '(') {
                temp.push(ch);
            } else {
                switch (ch) {
                    case '}':
                        if (temp.isEmpty() || temp.pop() != '{') return false;
                        else break;
                    case ']':
                        if (temp.isEmpty() || temp.pop() != '[') return false;
                        else break;
                    case ')':
                        if (temp.isEmpty() || temp.pop() != '(') return false;
                        else break;
                    default:
                        continue outer;
                }
            }
        }
        return temp.isEmpty();
    }

        public static int evaluateExpression(String expression) throws ClassCastException{
        Stack<Integer> value = new Stack<>();
        Stack<Character> operandStack = new Stack<>();
        String num = "";
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch == ' ') {
                continue;
            }
            if (Character.isDigit(ch)) {
                num += ch;
                value.push(Integer.parseInt(num));
                num = "";
            } else {
                switch (ch) {
                    case ')':
                        char temp = operandStack.pop();
                        if (operandStack.pop() == '(') {
                            value.push(calc(value.pop(), value.pop(), temp));
                        }
                        break;
                    case '(', '+', '-', '*', '/':
                        operandStack.push(ch);
                        break;
                    default:
                        throw new ClassCastException();
                }
            }
        }
            while ( !operandStack.isEmpty()){
                value.push(calc(value.pop(), value.pop(), operandStack.pop()));
        }
        return value.pop();
    }

    public static int calc(int b, int a, char ch) {
        switch (ch) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                return a / b;
        }
        return 0;
    }

    public static void main(String[] args) {
        Integer[] array = {5, 37, 9, 4, 6, 1};
//        test.reserve(array);
//        System.out.println(isCorrect("{([frsesdA])}"));
        System.out.println(evaluateExpression(" 1+ 2+ 3+(2*2)"));
    }
}
