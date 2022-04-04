package com.example.ticonetgamesserver.Models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class GamesDTO {

    private int _id;
    private String GameName;
    private String GameDescription;
    private String GameCategory;
    private String GameSize;
    private Double GamePrice;
    private String GameImage;
}
