package lab4;

import java.util.Arrays;

public class BasicSort {

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] > array[index]) {
                    index = j;
                }
            }
            swap(array, i, index);
        }
    }

    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            boolean stop = true;
            for (int j = i; j < array.length - 1 - i; j++) { // tru i vi moi lan swap nhung so o sau da duoc kt,thuat toan it phuc tap hon
                if (array[j] < array[j + 1]) {
                    swap(array, i, j);
                    stop = false;
                }
                if (stop) break;
            }
        }
    }

    public static void insertionSort(int[] array) {
        int n = array.length;
        for (int k = 1; k < n; k++) {
            int cur = array[k];
            int j = k;
            while (j > 0 && array[j - 1] < cur) {
                swap(array, j, j - 1);
                j--;
            }
        }
    }

    public static void mergeSort(int[] arr) {
        if (arr.length > 1) {
            int mid = arr.length / 2;
            int[] left = Arrays.copyOfRange(arr, 0, mid);
            int[] right = Arrays.copyOfRange(arr, mid, arr.length);
            mergeSort(left);
            mergeSort(right);
            merge(arr, left, right);
        }
    }

    private static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] > right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }
        while (i < left.length) {
            arr[k++] = left[i++];
        }
        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }


    public static void quickSort(int[] array) {
        int left = 0;
        int right = array.length -1;
        getPivot_MedianOfThree(array, left , right);
    }

    private static void getPivot_MedianOfThree(int[] array, int left, int right) {
        int mid = (left + right) / 2;
        int key = array[mid];
        int i = left; // i : nho
        int j = right; //j : lon

        while (i <= j) {
            while (array[i] > key) {
                i++;
            }
            while (array[j] < key) {
                j--;
            }
            if (i < j) {
                swap(array, i, j);
                i++;
                j--;
            }
        }
        if (left < j) {
            getPivot_MedianOfThree(array, left, j);
        }
        if (right > i) {
            getPivot_MedianOfThree(array, i, right);
        }
    }


//    public static int supportMerge(int[] array, int l, int r) {
//        int mid = 0;
//        if (l < r) {
//            mid = (l + r) / 2;
//            int leftArray = supportMerge(array, l, mid);
//            int rightArray = supportMerge(array, mid + 1, r);
//
////            int resultArray = merge(leftArray, rightArray, );
//        }
//        return 1;
//    }


    public static void main(String[] args) {
        int[] test = {4, 2, 8, 5, 73, 6, 10};
//        selectionSort(test);
//        bubbleSort(test);
//        insertionSort(test);
//        mergeSort(test);
        quickSort(test);
        System.out.println(Arrays.toString(test));
    }
}
