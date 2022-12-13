package com.onlinestoreboot.dto;

import com.onlinestoreboot.model.Customer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

/**
 * DTO class of {@link Customer} entity
 */
@NoArgsConstructor
@Getter
@Setter
public class CustomerDto {

    private String firstName;
    private String lastName;
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private LocalDate dateOfBirth;
    private String email;
    private String oldPassword;
    private String newPassword;

}
