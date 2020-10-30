package com.candiolli.fivestars.customer.application;

import com.candiolli.fivestars.customer.application.transformer.CustomerTransformer;
import com.candiolli.fivestars.customer.domain.repository.CustomerRepository;
import com.candiolli.fivestars.customer.domain.vo.CustomerVO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

//@RunWith(JUnitPlatform.class)
class CustomerRegisterTest {

    private CustomerRegister customerRegister;
    private CustomerRepository repository;
    private CustomerTransformer transformer;

    @DisplayName("Validate cpf Success")
    @Test
    void validate_cpf_success() {
        customerRegister = mock(CustomerRegister.class);

        when(customerRegister.validateRealCpf(anyString())).thenReturn(true);

        boolean b = customerRegister.validateRealCpf("8888 invalid");

        Assertions.assertTrue(b);
    }

    @DisplayName("Single test register a new customer")
    @Test
    void register_error_cpf() {
        customerRegister = spy(CustomerRegister.class);

        when(customerRegister.validateRealCpf(anyString())).thenReturn(false);

        CustomerVO vo = CustomerVO.builder()
                .cpf("8998989898")
                .name("Silas")
                .rg(123456L)
                .build();

        customerRegister.register(vo);
    }

    @Test
    void validateRealCpf() {
    }

    @Test
    void transform() {
    }
}