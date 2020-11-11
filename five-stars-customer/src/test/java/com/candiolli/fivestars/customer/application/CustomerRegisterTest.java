package com.candiolli.fivestars.customer.application;

import com.candiolli.fivestars.customer.domain.entity.Customer;
import com.candiolli.fivestars.customer.domain.repository.CustomerRepository;
import com.candiolli.fivestars.customer.domain.vo.CustomerVO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
class CustomerRegisterTest {

    @Spy
    @InjectMocks
    private CustomerRegister customerRegister;

    @Mock
    private CustomerRepository repository;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @DisplayName("Register a new customer")
    @Test
    void register_success() {
        Customer objectSaved = Customer.builder().id(1L).build();

        when(customerRegister.validateRealCpf(anyString())).thenReturn(true);
        when(repository.save(any(Customer.class))).thenReturn(objectSaved);

        CustomerVO vo = CustomerVO.builder()
                .cpf("111")
                .name("Silas")
                .rg(123456L)
                .build();

        Customer register = customerRegister.register(vo);
        Assertions.assertEquals(objectSaved.getId(), register.getId());
    }

    @DisplayName("Validate cpf Success")
    @Test
    void validate_cpf_success() {
        customerRegister = mock(CustomerRegister.class);

        when(customerRegister.validateRealCpf(anyString())).thenCallRealMethod();

        boolean b = customerRegister.validateRealCpf("8888 invalid");

        Assertions.assertTrue(b);
    }

    @DisplayName("Single test register a new customer")
    @Test
    void register_error_cpf() {
        customerRegister = spy(CustomerRegister.class);

        when(customerRegister.validateRealCpf(anyString())).thenReturn(false);

        CustomerVO vo = CustomerVO.builder()
                .cpf("83607056072")
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