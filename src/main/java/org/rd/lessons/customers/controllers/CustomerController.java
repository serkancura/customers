package org.rd.lessons.customers.controllers;

import org.rd.lessons.customers.dtos.CustomerDTO;
import org.rd.lessons.customers.models.Customer;
import org.rd.lessons.customers.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sound.midi.VoiceStatus;
import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/create-customer")
    public ResponseEntity createCustomer(){
        CustomerDTO customerDTO = CustomerDTO.builder()
                .firstname("John")
                .lastname("Doe")
                .build();

        customerService.addCustomer(customerDTO);
        return ResponseEntity.status(HttpStatus.OK).body(customerDTO);
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Integer id){
        Customer customer =customerService.getCustomerById(id);
        if (customer == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        return ResponseEntity.status(HttpStatus.OK).body(customer);
    }

    @GetMapping("/customers")
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @DeleteMapping("/customer/{id}")
    public ResponseEntity deleteCustomerById(@PathVariable Integer id){
        customerService.deleteCustomerById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Customer deleted");
    }
}
