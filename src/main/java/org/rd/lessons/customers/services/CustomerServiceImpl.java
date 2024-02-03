package org.rd.lessons.customers.services;

import org.rd.lessons.customers.dtos.CustomerDTO;
import org.rd.lessons.customers.models.Customer;
import org.rd.lessons.customers.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void addCustomer(CustomerDTO customerDTO) {
        Customer customer = null;
        if (customerDTO == null)
            throw new NullPointerException("Customer bilgilerini giriniz!");

        customer = Customer.builder()
                .firstname(customerDTO.getFirstname())
                .lastname(customerDTO.getLastname())
                .build();

        customerRepository.save(customer);

    }

    @Override
    public Customer getCustomerById(Integer id) {
        if (customerRepository.existsById(id))
            return customerRepository.findById(id).get();
        return null;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public void deleteCustomerById(Integer id) {
        if (customerRepository.existsById(id))
            customerRepository.deleteById(id);
    }
}
