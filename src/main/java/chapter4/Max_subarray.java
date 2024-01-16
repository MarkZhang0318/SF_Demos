package chapter4;

import java.util.ArrayList;
import java.util.Random;

public class Max_subarray {
    public static void main(String[] args) {
        int[] data = new int[100];
        int[] subData = new int[data.length - 1];
        Random r = new Random();
        for (int i = 0; i < data.length; i++) {
            data[i] = r.nextInt(200);
        }
        for (int i = 0; i < subData.length; i++) {
            subData[i] = data[i + 1] - data[i];
            //subData[i] = r.nextInt(200) - 200;
        }
        Tuple<Integer, Integer, Integer> resultTuple = findMaximumSubarray(subData, 0, subData.length - 1);

        int sum = 0;
        for (int i = resultTuple.first; i <= resultTuple.second; i++) {
            System.out.print(subData[i] + " ");
            sum += subData[i];
        }
        System.out.println();
        System.out.println(sum);
        System.out.println(resultTuple);

    }

    public static Tuple<Integer, Integer, Integer> findMaximumSubarray(int[] arr, int low, int high) {
        if (low == high) {
            return Tuple.of(low, high, arr[low]);
        } else {
            int mid = (low + high) / 2;
            Tuple<Integer, Integer, Integer> leftTuple = findMaximumSubarray(arr, low, mid);
            Tuple<Integer, Integer, Integer> rightTuple = findMaximumSubarray(arr, mid + 1, high);
            Tuple<Integer, Integer, Integer> crossTuple = findMaxCrossingSubarray(arr, low, mid, high);
            if (leftTuple.third >= rightTuple.third && leftTuple.third >= crossTuple.third) {
                return leftTuple;
            } else if (rightTuple.third >= leftTuple.third && rightTuple.third >= crossTuple.third) {
                return rightTuple;
            } else {
                return crossTuple;
            }
        }

    }

    public static Tuple<Integer, Integer, Integer> findMaxCrossingSubarray(int[] arr, int low, int mid, int high) {
        int leftSum = Integer.MIN_VALUE;
        int sum = 0;
        int leftMax = 0;
        for (int i = mid; i >= low; i--) {
            sum += arr[i];
            if (sum > leftSum) {
                leftSum = sum;
                leftMax = i;
            }
        }
        int rightSum = Integer.MIN_VALUE;
        sum = 0;
        int rightMax = 0;
        for (int i = mid + 1; i <= high; i++) {
            sum += arr[i];
            if (sum > rightSum) {
                rightSum = sum;
                rightMax = i;
            }
        }
        return Tuple.of(leftMax, rightMax, leftSum + rightSum);
    }
}
