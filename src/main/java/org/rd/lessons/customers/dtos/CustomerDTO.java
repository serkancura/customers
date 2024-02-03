package org.rd.lessons.customers.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Builder
@Getter
@Setter
public class CustomerDTO implements Serializable {

    private String firstname;
    private String lastname;

}
