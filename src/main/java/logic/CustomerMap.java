package logic;
import io.View;
import service.CustomerService;
import java.util.*;
import java.util.stream.Collectors;

public class CustomerMap {
    public Map<String , List<Customer>> sortByCityAndName(){
        Map<String, List<Customer>> customers = CustomerService.returnCustomers()
                .stream()
                .sorted(Comparator.comparing(Customer::getFullName))
                .collect(Collectors.groupingBy(Customer::getCity));
        return customers;
    }
    public Map<String, Double> sortByAllOutlay(){
        Map<String, Double> map = CustomerService.returnCustomers()
                .stream()
                .collect(Collectors.groupingBy(Customer::getCity, Collectors.summingDouble(Customer::getNumberOutlay)));
        return map;
    }

}
