package com.candiolli.fivestars.customer.application;

import br.com.caelum.stella.validation.CPFValidator;
import br.com.caelum.stella.validation.InvalidStateException;
import com.candiolli.fivestars.customer.application.transformer.CustomerTransformer;
import com.candiolli.fivestars.customer.domain.entity.Customer;
import com.candiolli.fivestars.customer.domain.repository.CustomerRepository;
import com.candiolli.fivestars.customer.domain.vo.CustomerVO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class CustomerRegister {

    @Autowired
    private CustomerRepository repository;

    @Autowired
    private CustomerTransformer transformer;

//    public CustomerVO register(CustomerVO customerVO) {
//        if (validateNulls(customerVO) || validateRealCpf(customerVO.getCpf())) {
//            Customer entity = new Customer();// TODO invocar metodo de transformação transformer.transform(customerVO);
//            return transformer.transform(repository.save(entity));
//        }
//        return null;
//    }

    public Customer register(CustomerVO customerVO) {
        if (validateNulls(customerVO) || validateRealCpf(customerVO.getCpf())) {
            Customer entity = transform(customerVO);
            return repository.save(entity);
        }
        return null;
    }

    public Customer transform(CustomerVO customerVO) {
        return Customer.builder()
                .id(customerVO.getId())
                .cpf(customerVO.getCpf())
                .rg(customerVO.getRg())
                .name(customerVO.getName())
                .build();
    }

    public boolean validateRealCpf(String cpf) {
        CPFValidator cpfValidator = new CPFValidator();
        try {
            cpfValidator.assertValid(cpf);
            return true;
        } catch (InvalidStateException e) {
            return false;
        }
    }

    private boolean validateNulls(CustomerVO customerVO) {
        if (customerVO.getCpf() != null && customerVO.getName() != null && customerVO.getRg() != null)
            return true;
        return false;
    }

    public void rename(CustomerVO customerVO) {
        Optional<Customer> entity = repository.findById(customerVO.getId());
        entity.get().setName(customerVO.getName());
    }
}
