package lab1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

        public int[] getMissingValues1 () {
            int min = array[0];
            int max = array[array.length - 1];
            List<Integer> missingValues = new ArrayList<>();

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
                result[i] = missingValues.get(i);
            }

            return result;
        }
        public static void main (String[]args){
            int[] arr = {1, 3, 5, 7, 9, 3, 7, 8, 9, 10};
            int[] array = {10, 10, 11, 12, 13, 14, 16, 17, 20};
            MyArray test = new MyArray(array);
//        System.out.println(Arrays.toString(test.mirror()));
//        System.out.print(remove2(arr));
//        System.out.print(Arrays.toString(test.removeDuplicates()));
            System.out.print(test.getMissingValues().toString());
            System.out.print(Arrays.toString(test.getMissingValues1()));
        }
    }
