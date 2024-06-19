package task3;

public class Pair<A, B> {
    public A a;
    public B b;

    public Pair(A a, B b) {
        this.a = a;
        this.b = b;
    }

    public A getFirst() {
        return a;
    }

    public B getSecond() {
        return b;
    }

    @Override
    public String toString() {
        return "First[" + a.getClass().getSimpleName() + "]=" + a + ", " +
                "Second[" + b.getClass().getSimpleName() + "]=" + b;
    }
}
