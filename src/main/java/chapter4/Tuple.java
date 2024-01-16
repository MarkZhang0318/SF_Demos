package chapter4;

public class Tuple<A, B, C> {
    public A first;
    public B second;
    public C third;

    public Tuple(A first, B second, C third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public static <A, B, C> Tuple<A, B, C> of(A first, B second, C third) {
        return new Tuple<A, B, C>(first, second, third);
    }

    @Override
    public String toString() {
        return "Tuple{" +
                "first=" + first +
                ", second=" + second +
                ", third=" + third +
                '}';
    }
}
