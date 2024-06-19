package task2;

public class Main {
    //Напишите обобщенный метод compareArrays(), который принимает два массива и возвращает true, если они одинаковые,
    // и false в противном случае.
    // Массивы могут быть любого типа данных, но должны иметь одинаковую длину и содержать элементы одного типа по парно по индексам.


    public static <T extends Object> boolean compareArrays(T[] arr1, T[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].getClass().getName().equals(arr2[i].getClass().getName())) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(compareArrays(new Integer[]{1, 2, 3}, new Integer[]{4, 5, 6}));
        System.out.println(compareArrays(new Number[]{1, 2, 3}, new Integer[]{4, 5, 6}));
        System.out.println(compareArrays(new Number[]{1, 2, 3}, new String[]{"1", "2", "3"}));
        System.out.println(compareArrays(new Integer[]{1, 2}, new Integer[]{4, 5, 6}));


    }
}
