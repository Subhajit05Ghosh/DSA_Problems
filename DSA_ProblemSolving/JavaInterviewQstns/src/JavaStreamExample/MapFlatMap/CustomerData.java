package JavaStreamExample.MapFlatMap;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CustomerData {


    public static List<Customer> getAll() {
        return Stream.of(
                new Customer(101, "john", "john@gmail.com", List.of("397937955", "21654725")),
                new Customer(102, "smith", "smith@gmail.com", List.of("89563865", "2487238947")),
                new Customer(103, "peter", "peter@gmail.com", List.of("38946328654", "3286487236")),
                new Customer(104, "kely", "kely@gmail.com", List.of("389246829364", "948609467"))
        ).collect(Collectors.toList());
    }

}