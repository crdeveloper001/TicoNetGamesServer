package com.example.ticonetgamesserver.Models;

import lombok.*;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UsersDTO {

    @Id
    private int _id;
    private String Name;
    private int Phone;
    private String Mail;
    private String Password;
    private String Role;
    private Date UserRegistrationData;
}
