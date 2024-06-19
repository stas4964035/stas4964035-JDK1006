package task3;

import java.io.FileReader;

public class Main {
    //Напишите обобщенный класс Pair, который представляет собой пару значений разного типа.
    // Класс должен иметь методы getFirst(), getSecond() для получения значений каждого из составляющих пары,
    // а также переопределение метода toString(), возвращающее строковое представление пары.

    public static void main(String[] args) {
        System.out.println(new Pair<>("13", 37));
        System.out.println(new Pair<>(0.5, true));
        System.out.println(new Pair<>('a', (int) 'b'));

    }
}
