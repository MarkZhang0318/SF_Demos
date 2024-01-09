package chapter2;

import java.util.Arrays;

public class Insertion_sort {
    public static void main(String[] args) {
        int[] arr = {5, 9, 2, 4, 6, 7, 1, 3};
        int j;
        System.out.println(Arrays.toString(arr));
        System.out.println("===============");
        /*Java的计数从0开始，因此j从1开始，i从0开始，先从前两个开始排序，再从第三个开始排序，以此类推*/
        for (j = 1; j < arr.length; j++) {
            int key = arr[j];
            int i = j - 1;
            /*当排序前2个数时，如果第1个数大于第二个，就交换二者顺序
            * 当排序第三个时，由于前两个数已经被排好顺序，因此只需要对比2和3的大小
            * 如果2小于3，那么2以前的数都小于3
            * 如果2大于3，就将2的值赋给3，然后再检查2前面的数是否大于3
            * 由于先赋值再i--，当某一个i处的值不再小于key时，就说明key应该排在i+1的位置*/
            //while (i >= 0 && arr[i] > key) {
            while (i >= 0 && arr[i] < key) {
                arr[i + 1] = arr[i];
                i--;
                System.out.println(Arrays.toString(arr));
            }
            arr[i + 1] = key;
            System.out.println(Arrays.toString(arr));
            System.out.println("=============");
        }
        System.out.println(Arrays.toString(arr));

    }
}
