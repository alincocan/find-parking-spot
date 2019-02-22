package com.parking.findparkingspot.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    private String id;
    @NotNull(message = "First name could not be null")
    private String lastName;
    @NotNull(message = "Last name could not be null")
    private String firstName;
    @NotNull(message = "Phone number could not be null")
    private String phoneNumber;

}
