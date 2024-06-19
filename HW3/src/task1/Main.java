package task1;

public class Main {
    //    Написать класс Калькулятор (необобщенный), который содержит обобщенные статические методы:
    //    sum(), multiply(), divide(), subtract().
    //    Параметры этих методов – два числа разного типа, над которыми должна быть произведена операция.
    //    Методы должны возвращать результат своей работы.
    public static void main(String[] args) {
        System.out.println(Calculator.sum(2, -1));
        System.out.println(Calculator.multiply(2, 1.2f));
        System.out.println(Calculator.divide(42, 11));
        System.out.println(Calculator.subtract(10, 10));
    }
}
