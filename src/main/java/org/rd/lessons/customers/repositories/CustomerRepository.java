package org.rd.lessons.customers.repositories;

import org.rd.lessons.customers.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
