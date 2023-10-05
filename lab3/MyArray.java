package lab3;

import java.util.Arrays;

public class MyArray {
    private int[] array;

    public MyArray(int[] array) {
        this.array = array;
    }

    //task1.1
    public int iterativeLinearSearch(int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public int recursiveLinearSearch(int target) {
        return supportLinearSearch(target, array.length);
    }

    public int supportLinearSearch(int target, int size) {
        if (size == 0) {
            return -1;
        } else if (array[size - 1] == target) {
            return size - 1;
        } else {
            return supportLinearSearch(target, size - 1);
        }
    }

    //task1.2

    public int iterativeBinarySearch(int target) {
        Arrays.sort(array);
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = (high + low) / 2;
            if (target == array[mid]) {
                return mid;
            } else if (target < array[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public int recursiveBinarySearch(int target) {
        Arrays.sort(array);
        return supportRecuriveBinarySearch(target, 0, array.length);
    }

    public int supportRecuriveBinarySearch(int target, int low, int high) {
        if (low > high) {
            return -1;
        } else {
            int mid = (low + high) / 2;
            if (target == array[mid]) {
                return mid;
            } else if (target < array[mid]) {
                return supportRecuriveBinarySearch(target, low, mid - 1);
            } else {
                return supportRecuriveBinarySearch(target, high, mid + 1);
            }
        }
    }


    public static void main(String[] args) {
        int[] arr = {12, 9, 45, 2, 8, 4, 14, 10, 45};
        MyArray test = new MyArray(arr);
//        System.out.println(test.iterativeLinearSearch(45));
//        System.out.println(test.recursiveLinearSearch(45));
        System.out.println(test.iterativeBinarySearch(12));
    }

}
