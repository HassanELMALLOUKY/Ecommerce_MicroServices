package org.sid.customerservice.entities.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import java.io.Serializable;
import java.time.LocalDate;
//@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Data
public class CustomerDTO implements Serializable {
    private Long id;
    private String fistName;
    private String lastName;
    private LocalDate birthday;
    private String phoneNumber;
    private String address;
}
