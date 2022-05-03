package com.example.ticonetgamesserver.Models;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ShoppingDTO {

    private int _id;
    private String UserName;
    private String UserEmail;
    private int UserPhone;
    private String BillingAddress;
    private Long CreditCard;
    private Date CreditCardExpiration;
    private Double Price;

}
