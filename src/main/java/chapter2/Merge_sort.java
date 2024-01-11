package chapter2;

import java.util.Arrays;
import java.util.Random;

public class Merge_sort {
    public static void main(String[] args) {
        int[] arr = new int[10];
        Random r = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(100);
        }
        int[] ints = merge_sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(ints));
    }
    public static int[] merge_sort(int[] arr, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            merge_sort(arr, p, q);
            merge_sort(arr, q + 1, r);
            merge(arr, p, q, r);
        }
        return arr;
    }

    public static int[] merge(int[] arr, int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;

        int[] L = new int[n1 + 1];
        int[] R = new int[n2 + 1];

        for (int i = 0; i < n1; i++) {
            L[i] = arr[p + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = arr[q + 1 + j];
        }
        L[n1] = Integer.MAX_VALUE;
        R[n2] = Integer.MAX_VALUE;

        int i = 0, j = 0;
        for (int k = p; k <= r; k++) {
            if (i < n1 &&L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else if (j < n2){
                arr[k] = R[j];
                j++;
            }
        }
        return arr;
    }

}
