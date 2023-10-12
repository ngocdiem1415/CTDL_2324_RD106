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

    public static int[] mergeSort(int[] arr, int left, int right) {
        if (left == right) return arr;
        int mid = (left + right) / 2;
        int[] arr1 = mergeSort(arr, left, mid);
        int[] arr2 = mergeSort(arr, mid + 1, right);

//        int[] result = merge(arr, arr1, arr2);
        //tron vao: arr1 va arr2 la 2 mang da duoc sap xep
        int length = arr1.length + arr2.length;
        int[] result = new int[length];
        int i = 0;
        int i1 = 0;
        int i2 = 0;
        while (i1 < arr1.length && i2 < arr2.length) {
            if (arr1[i1] <= arr2[i2]) {
                result[i++] = arr2[i2++];
            } else {
                result[i++] = arr1[i1++];
            }
        }
        while (i1 < arr1.length) {
            result[i++] = arr1[i1++];
        }
        while (i2 < arr2.length) {
            result[i++] = arr2[i2++];
        }
        return result;
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
//        System.out.println(left.length);
//        System.out.println(right.length);
    }


    public static void quickSort(int[] array) {
        int left = 0;
        int right = array.length - 1;
        getPivot_MedianOfThree(array, left, right);
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
            if (i <= j) {// dieu kien dung
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

    public static void main(String[] args) {
        int[] test = {4, 2, 83, 5, 7, 6, 10};
//        selectionSort(test);
//        bubbleSort(test);
//        insertionSort(test);
//        mergeSort(test);
        quickSort(test);
        System.out.println(Arrays.toString(test));
    }
}
