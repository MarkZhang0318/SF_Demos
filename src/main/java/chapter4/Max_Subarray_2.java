package chapter4;

import java.util.Arrays;
import java.util.Random;

public class Max_Subarray_2 {
    public static void main(String[] args) {
        //创建并初始化数组,采用随机数填充数组
        int[] data = new int[100];
        int[] subData = new int[data.length - 1];
        Random r = new Random();
        for (int i = 0; i < data.length; i++) {
            data[i] = r.nextInt(200);
        }
        //随机数数组的差值数组
        for (int i = 0; i < subData.length; i++) {
            subData[i] = data[i + 1] - data[i];
        }
        //初始化结果元组,sum直接初始化为最小值
        Tuple<Integer, Integer, Integer> last = Tuple.of(0, 0, Integer.MIN_VALUE);
        //从索引1开始, 调用下面的方法, 计算每一个子数组的最大子数组
        for (int i = 1; i < subData.length; i++) {
            //截取从0开始i+1长度的子数组
            //索引为i时,长度为i+1
            last = findMaxSubarray(Arrays.copyOf(subData, i + 1), last);
        }
        System.out.println(Arrays.toString(Arrays.copyOfRange(subData, last.first, last.second + 1)));
        System.out.println(last.toString());

    }

    public static Tuple<Integer, Integer, Integer> findMaxSubarray(int[] subArray, Tuple<Integer, Integer, Integer> last) {
        int sum = 0;
        for (int i = subArray.length - 1; i >= 0; i--) {
            sum += subArray[i];
            //如果sum大于了上一轮的结果，就记录当前的子数组左右值和最大值
            if (sum >= last.third) {
                /*此处需要做替换
                * 因为只要找到一个最大子数组就可以,此处用>=, 意味着当存在多个最大子数组的时候,只需要取最后找到的这个*/
                last.first = i;
                last.second = subArray.length - 1;
                last.third = sum;
            }
        }
        return last;
    }
}
