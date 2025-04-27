package JavaStreamExample.MapFlatMap;

import java.util.*;
import java.util.stream.Collectors;

public class MapFlatMap {
    public static void main(String[] args) {
        List<Customer> customerData=CustomerData.getAll();
        //List<Customer>  convert List<String> -> Data Transformation
        //mapping : customer -> customer.getEmail()
        //customer -> customer.getEmail()  one to one mapping
        List<String> emailInfo = customerData.stream().map(data -> data.getEmail()).collect(Collectors.toList());
        List<String> emailID = customerData.stream()
                .map(Customer::getEmail)
                .collect(Collectors.toList());
        System.out.println("EMAIL ID =>"+emailInfo);
        //List<Customer>  convert List<String> -> Data Transformation
        //mapping : customer -> phone Numbers
        //customer -> customer.getPhoneNumbers()  ->> one to many mapping

        List<String> phoneNo=customerData.stream().flatMap(data->data.getPhoneNumbers().stream()).collect(Collectors.toList());
        System.out.println("Phone Numbers =>"+phoneNo);
    }
}
