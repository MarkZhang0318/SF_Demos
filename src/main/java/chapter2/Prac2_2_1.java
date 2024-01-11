package chapter2;

import java.util.Arrays;

public class Prac2_2_1 {
    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 4, 6, 5};
        for (int i = 0; i < arr.length - 1; i++) {
            int temp = arr[i];

            for (int j = i; j < arr.length; j++) {
                if (arr[j] < temp) {
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(arr));

    }
}
