package explorecards.array;

import java.util.Arrays;

public class DuplicateZeros {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(duplicateZeros(new int[]{1, 0, 2, 3, 0, 4, 5, 0})));
    }

    public static int[] duplicateZeros(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                shiftToRight(i, arr);
                i++;
            }
        }
        return arr;
    }

    public static void shiftToRight(int i, int[] arr) {
        for (int j = arr.length - 1; j > i; j--) {
            arr[j] = arr[j - 1];
        }
    }

    public void duplicateZero(int[] arr) {
        int zeros = 0;
        for (int i : arr) {
            if (i == 0) {
                zeros++;
            }
        }
        int i = arr.length - 1, j = arr.length + zeros - 1;
        while (i != j) {
            insert(arr, i, j--);
            if (arr[i] == 0) {
                insert(arr, i, j--);
            }
            i--;
        }
    }

    public void insert(int[] arr, int i, int j) {
        if (j < arr.length) {
            arr[j] = arr[i];
        }
    }
}
