package lab4;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void quickSort(int[] array) {
        int left = 0;
        int right = array.length - 1;
        getPivot_MedianOfThree(array, left, right);
//        getPivot_First(array, left, right);
//        getPivot_Last(array, left, right);
        //random
//        Random rd = new Random();
//        int random = rd.nextInt(array.length -1);
//        System.out.println(random);
//        getPivot_Random(array,left,right,random);
    }

    private static void getPivot_MedianOfThree(int[] array, int left, int right) {
        int mid = (left + right) / 2;
        int pivot = array[mid];
        int i = left; // i : nho
        int j = right; //j : lon

        while (i <= j) {
            while (array[i] > pivot) {
                i++;
            }
            while (array[j] < pivot) {
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

    private static void getPivot_First(int[] array, int left, int right) {
        int pivot = array[left];
        int i = left;
        int j = right;

        while (i <= j) {
            while (array[j] < pivot) {
                j--;
            }
            while (array[i] > pivot) {
                i++;
            }
            if (i <= j) {// dieu kien dung
                swap(array, i, j);
                i++;
                j--;
            }
            if (left < j) {
                getPivot_First(array, left, j);
            }
            if (right > i) {
                getPivot_First(array, i, right);
            }
        }
    }

    private static void getPivot_Last(int[] array, int left, int right) {
        int pivot = array[right];
        int i = left;
        int j = right;

        while (i <= j) {
            while (array[j] < pivot) {
                j--;
            }
            while (array[i] > pivot) {
                i++;
            }
            if (i <= j) {// dieu kien dung
                swap(array, i, j);
                i++;
                j--;
            }
            if (left < j) {
                getPivot_Last(array, left, j);
            }
            if (right > i) {
                getPivot_Last(array, i, right);
            }
        }
    }

    private static void getPivot_Random(int[] array, int left, int right, int random) {
        int pivot = array[random];
        int i = left;
        int j = right;

        while (i <= j) {
            while (array[j] < pivot) {
                j--;
            }
            while (array[i] > pivot) {
                i++;
            }
            if (i <= j) {// dieu kien dung
                swap(array, i, j);
                i++;
                j--;
            }
            if (left < j) {
                getPivot_Last(array, left, j);
            }
            if (right > i) {
                getPivot_Last(array, i, right);
            }
        }
    }

    public static void main(String[] args) {
//        int[] test = {4, 2, 83, 5, 7, 6, 10};
        int[] test = {5, 4, 10, 2, 9, 45, 9};
//        selectionSort(test);
//        bubbleSort(test);
//        insertionSort(test);
//        mergeSort(test);
        quickSort(test);
        System.out.println(Arrays.toString(test));
    }
}
