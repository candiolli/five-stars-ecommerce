package com.candiolli.fivestars.customer.application.transformer;

import com.candiolli.fivestars.customer.domain.entity.Customer;
import com.candiolli.fivestars.customer.domain.vo.CustomerVO;

public class CustomerTransformer {

    public Customer transform(CustomerVO customerVO) {
        return Customer.builder()
                .id(customerVO.getId())
                .cpf(customerVO.getCpf())
                .rg(customerVO.getRg())
                .name(customerVO.getName())
                .build();
    }

    public CustomerVO transform(Customer customer) {
        return CustomerVO.builder()
                .id(customer.getId())
                .cpf(customer.getCpf())
                .rg(customer.getRg())
                .name(customer.getName())
                .build();
    }

}
