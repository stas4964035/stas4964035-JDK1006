package task1;

public class Calculator {
    // Тут я решил приводить оба числа к максимальному по вместимости типу - Double и возвращать как результат строку.

    public static <A extends Number, B extends Number> String sum(A a, B b) {
        return Double.toString(a.doubleValue() + b.doubleValue());
    }
    public static <A extends Number, B extends Number> String multiply(A a, B b) {
        return Double.toString(a.doubleValue() * b.doubleValue());
    }
    public static <A extends Number, B extends Number> String divide(A a, B b) {
        return Double.toString(a.doubleValue() / b.doubleValue());
    }
    public static <A extends Number, B extends Number> String subtract(A a, B b) {
        return Double.toString(a.doubleValue() - b.doubleValue());
    }
}
