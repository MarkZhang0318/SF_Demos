package chapter1;

import static jdk.nashorn.internal.objects.Global.println;

public class Demo2_3 {
    public static void main(String[] args) {
        int n = 1;
        while (100 * Math.pow(n, 2) > Math.pow(2, n)) {
            n++;
        }
        System.out.println(n);

    }
}
