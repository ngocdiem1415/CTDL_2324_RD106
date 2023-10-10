package lab4;

import java.util.Arrays;

public class BasicSort {

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }

    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int index = i;
            for (int j = i +1 ; j < array.length ; j++) {
                if (array[j] > array[index]) {
                    index = j;
                }
            }
            swap(array, i, index);
        }
    }

    public static void bubbleSort ( int[] array){
        for ( int i = 0; i < array.length -1; i ++){
            boolean stop = true;
            for ( int j =i ; j < array.length -1 -i ; j++){ // tru i vi moi lan swap nhung so o sau da duoc kt,thuat toan it phuc tap hon
                if ( array[j] < array[j+1]){
                    swap(array, i, j);
                    stop = false;
                }if ( stop) break;
            }
        }
    }

    public static void insertionSort(int[] array ){
        int n = array.length;
        for ( int k =1 ; k < n ; k++){
            int cur = array[k];
            int j = k;
            while ( j >0 && array[j-1] < cur){
                swap(array, j , j-1 );
                j--;
            }
        }
    }

    public static void mergeSort (int[] array){

    }

    public static int[] merge ( int )
    public static int supportMerge(int[] array, int l, int r){
        int mid =0;
        if ( l < r){
            mid = ( l + r)/2;
           int leftArray = supportMerge(array, l, mid);
           int rightArray = supportMerge(array, mid +1, r);
           int resultArray = merge(leftArray, rightArray,);
        }
    }
    public static void main(String[] args) {
        int[] test = { 4,2,8,5,73,6,10};
//        selectionSort(test);
//        bubbleSort(test);
        insertionSort(test);
        System.out.println(Arrays.toString(test));
    }
}
