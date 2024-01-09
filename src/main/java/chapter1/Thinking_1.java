package chapter1;

import java.util.Scanner;

public class Thinking_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入一个时间time");

        long time = sc.nextInt();
        System.out.println(time);
        /*System.out.println(Math.log(time) / Math.log(2));*/

        int n = 1;
        while (factorial(n) < time) {

            n++;
        }
        System.out.println(n);

    }

    static double factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
}
