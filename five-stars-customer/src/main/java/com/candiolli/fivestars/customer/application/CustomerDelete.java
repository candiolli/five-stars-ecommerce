package com.candiolli.fivestars.customer.application;

import com.candiolli.fivestars.customer.domain.entity.Customer;
import com.candiolli.fivestars.customer.domain.repository.CustomerRepository;
import com.candiolli.fivestars.customer.domain.vo.CustomerVO;

public class CustomerDelete {

    private CustomerRepository customerRepository;

    public void logicalDelete(CustomerVO customerVO) {
        Customer t = customerRepository.findById(customerVO.getId()).get();
        t.setAtivo(false);
        customerRepository.save(t);
    }

}
