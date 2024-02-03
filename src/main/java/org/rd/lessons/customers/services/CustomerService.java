package org.rd.lessons.customers.services;

import org.rd.lessons.customers.dtos.CustomerDTO;
import org.rd.lessons.customers.models.Customer;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@Service
public interface CustomerService {
    void addCustomer(CustomerDTO customerDTO);
    Customer getCustomerById(Integer id);
    List<Customer> getAllCustomers();
    void deleteCustomerById(Integer id);
}
