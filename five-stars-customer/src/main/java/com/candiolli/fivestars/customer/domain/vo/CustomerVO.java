package com.candiolli.fivestars.customer.domain.vo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerVO {

    private Long id;
    private String name;
    private String cpf;
    private Long rg;

}
