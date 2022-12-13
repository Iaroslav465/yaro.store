package com.onlinestoreboot.statistics;

import com.onlinestoreboot.model.Customer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Class that stores {@link Customer} statistics
 */
@NoArgsConstructor
@Getter
@Setter
public class CustomerStatistics {

    private String firstName;
    private String lastName;
    private String email;
    private Long purchasesTotal;
}
