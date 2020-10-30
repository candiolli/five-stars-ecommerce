package com.candiolli.fivestars.customer.infrastructure;

import com.candiolli.fivestars.customer.application.CustomerDelete;
import com.candiolli.fivestars.customer.application.CustomerRegister;
import com.candiolli.fivestars.customer.domain.vo.CustomerVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

public class CustomerController {

    @Autowired
    private CustomerRegister customerRegister;

    @Autowired
    private CustomerDelete customerDelete;

    public ResponseEntity register(CustomerVO customerVO) {
        customerRegister.register(customerVO);
        return ResponseEntity.ok(null);
    }

    public ResponseEntity delete(CustomerVO customerVO) {
        customerDelete.logicalDelete(customerVO);
        return ResponseEntity.ok(null);
    }

}
