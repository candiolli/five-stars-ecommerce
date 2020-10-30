package com.candiolli.fivestars.customer.domain.repository;

import com.candiolli.fivestars.customer.domain.entity.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
