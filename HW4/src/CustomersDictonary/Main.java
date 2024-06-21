package CustomersDictonary;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        CustomersDictonary.addCustomer("123", "Ivan", 5);
        CustomersDictonary.addCustomer("678", "Ivan", 3);
        CustomersDictonary.addCustomer("456", "Petr", 2);
        CustomersDictonary.addCustomer("789", "Alex", 6);
        CustomersDictonary.addCustomer("123", "Elena", 2);

        Integer[] arr = new Integer[2];
        arr[0] = 5;
        arr[1] = 6;
        printList(CustomersDictonary.getCustomersByExp(2));
        printList(CustomersDictonary.getCustomersByExp(arr));

        String[] names = new String[2];
        names[0] = "Ivan";
        names[1] = "Petr";
        printList(CustomersDictonary.getPhonesByName("Elena"));
        printList(CustomersDictonary.getPhonesByName(names));

        System.out.println(CustomersDictonary.getCustomerById(3));
        System.out.println(CustomersDictonary.getCustomerById(5));

    }
    public static<T> void printList(List<T> list){
        for(T c : list){
            System.out.println(c.toString());
        }
    }
}
