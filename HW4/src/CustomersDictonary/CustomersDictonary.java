package CustomersDictonary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CustomersDictonary {
    private static List<Customer> customers = new ArrayList<Customer>();
    private static int id = 0;

    public static void addCustomer(String phone, String name, int exp) {
        customers.add(new Customer(++id, phone, name, exp));
    }

    public static List<Customer> getCustomersByExp(int exp) {
        return customers.stream().filter(customer -> customer.experience() == exp).toList();
    }

    public static List<Customer> getCustomersByExp(Integer[] exp) {
        return customers.stream().filter(customer -> Arrays.asList(exp).contains(customer.experience())).toList();
    }

    public static List<String> getPhonesByName(String name) {
        return customers.stream()
                .filter(customer -> customer.name() == name)
                .map(Customer::phone)
                .toList();
    }

    public static List<String> getPhonesByName(String[] names) {
        List<String> phones = new ArrayList<>();
        for (String name : names) {
            phones.addAll(getPhonesByName(name));
        }
        return phones;
    }

    public static Customer getCustomerById(int id) {
        return customers.stream().filter(customer -> customer.id() == id).findFirst().get();
    }
}
