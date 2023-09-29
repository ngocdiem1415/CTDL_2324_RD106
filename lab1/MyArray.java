package lab1;

import java.util.ArrayList;
import java.util.Arrays;

public class MyArray {
    private int[] array;

    public MyArray(int[] array) {
        this.array = array;
    }

    //task1.1
    public int[] mirror() {
        int[] result = new int[array.length * 2];
        for (int i = 0; i < array.length; i++) {
            result[i] = array[i];
            result[result.length - 1 - i] = array[i];
        }
        return result;
    }

    public boolean checkValue(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value)
                return true;
        }
        return false;
    }


    public int count() {
        int count = 0;
        for (int i = 0; i < array.length - 1; i++) {
            for (int z = i + 1; z < array.length; z++) {
                if (array[i] == array[z]) {
                    count++;
                }
            }
        }
        return count;
    }

    public int[] removeDuplicates() {
        int index = 0;
        int[] result = new int[array.length - count()];
        for (int i = 0; i < array.length; i++) {
            if (!checkValue(result, array[i])) {
                result[index++] = array[i];
            }
        }
        return result;
    }

    //task1.2
    public int[] getMissingValues() {
        if (array.length < 0) return null;
        boolean found = false;
        int count = 0;
//        for (int a = 0; a < array.length - 1; a++) {
//            if (array[a + 1] != array[a] + 1) {
//                found = true;
//                count++;
//            }
//            int[] result = new int[count];
//            while (found == true) {
//                result[a] = array[a] + 1;
//            }
//        }
        return null;
    }

    public int[] getMissingValues1() {
        int min = array[0];
        int max = array[array.length - 1];
        ArrayList missingValues = new ArrayList<>();

        for (int i = min; i <= max; i++) {
            boolean found = false;
            for (int j = 0; j < array.length; j++) {
                if (array[j] == i) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                missingValues.add(i);
            }
        }
        int[] result = new int[missingValues.size()];
        for (int i = 0; i < missingValues.size(); i++) {
            result[i] = (int) missingValues.get(i);
        }

        return result;
    }

    public int[] fillMissingValue(int k) {
        int[] listIndex = new int[array.length];
        int cursor =0; // bien dem
        for ( int i = 1; i < array.length ; i++){
            if (array[ i - 1] > array[i] || array[i] == -1){
                listIndex[cursor ++] = i;// luu vi tri
                    //cho k = 3
                    int sum =0;

                    // j =1
                    for ( int j =1 ; j < k/2 +1 ; j++){
                        sum += array[i-j];
                        sum += array[i +j];
                    }
                    if ( k % 2 ==1){
                        if ( array[i -k/2 -1] > array[i + k/2 +1] && array[i + k /2 +1] != -1){
                            sum += array[i +k/2 +1];

                        }else if ( indexOf(listIndex, i -k/2 -1 ) != -1 && i -k/2 -1 != 0){
                            sum += array[ i + k/2 +1];

                        }else {
                        sum += array[i - k / 2 - 1];
                    }
                }
                sum /=k;
                array[i] = sum;
            }
        }
        return array;
    }

    public int indexOf(int[] lastIndex , int a){
        for( int i =0; i < lastIndex.length ; i++){
            if ( a == lastIndex[i]){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 3, 7, 8, 9, 10};
        int[] array = {10,11, 12, -1, 14,10,17,19, 20};
        MyArray test = new MyArray(array);
//        System.out.println(Arrays.toString(test.mirror()));
//        System.out.print(remove2(arr));
//        System.out.print(Arrays.toString(test.removeDuplicates()));
//        System.out.print(test.getMissingValues().toString());
//        System.out.print(Arrays.toString(test.getMissingValues1()));
        System.out.println(Arrays.toString(test.fillMissingValue(3)));
    }
}
