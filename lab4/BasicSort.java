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
        for (int i = 0; i < array.length - 1; i++) {// dung de dem so phantu da vao dung vi tri
//            boolean stop = true;
            for (int j = 0; j < array.length - 1 - i; j++) { // tru i vi moi lan swap nhuong so o sau da duoc kt,thuat toan it phuc tap hon
                if (array[j + 1] > array[j]) {
                    swap(array, j, j + 1);
//                    stop = false;
                }
//                if (stop) break;
            }
        }
    }

    public static void insertionSort(int[] array) {
        int n = array.length;
        for (int k = 1; k < n; k++) {
            int cur = array[k];
            int j = k;
            while (j > 0 && array[j - 1] < cur) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = cur;
        }
    }

    private static void sortArray(int[] arr, int[] left, int[] right) {
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
//        System.out.println(left.length);
//        System.out.println(right.length);
    }

    public static void mergeSort(int[] arr) {
        if (arr.length > 1) {
            int mid = arr.length / 2;
            int[] left = Arrays.copyOfRange(arr, 0, mid);
            int[] right = Arrays.copyOfRange(arr, mid, arr.length);
            mergeSort(left);
            mergeSort(right);
            sortArray(arr, left, right);
        }
    }
//    public static int[] mergeSort(int[] arr, int left, int right) {
//        if (left == right) return arr;
//        int mid = (left + right) / 2;
//        int[] arr1 = mergeSort(arr, left, mid);
//        int[] arr2 = mergeSort(arr, mid + 1, right);
//
////        int[] result = merge(arr, arr1, arr2);
//        //tron vao: arr1 va arr2 la 2 mang da duoc sap xep
//        int length = arr1.length + arr2.length;
//        int[] result = new int[length];
//        int i = 0;
//        int i1 = 0;
//        int i2 = 0;
//        while (i1 < arr1.length && i2 < arr2.length) {
//            if (arr1[i1] <= arr2[i2]) {
//                result[i++] = arr2[i2++];
//            } else {
//                result[i++] = arr1[i1++];
//            }
//        }
//        while (i1 < arr1.length) {
//            result[i++] = arr1[i1++];
//        }
//        while (i2 < arr2.length) {
//            result[i++] = arr2[i2++];
//        }
//        return result;

//    }

    public static void main(String[] args) {
//        int[] test = {4, 2, 83, 5, 7, 6, 10};
        int[] test = {5, 4, 10, 2, 9, 45, 9};
//        selectionSort(test);
//        bubbleSort(test);
//        insertionSort(test);
//        mergeSort(test);
        System.out.println(Arrays.toString(test));
    }
}
