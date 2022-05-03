package com.example.ticonetgamesserver.Models;

import java.util.List;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class GamesLibraryDTO {

    private int _id;
    private String GameName;
    private String GameDescription;
    private String GameCategory;
    private String GameSize;
    private String GameImage;

}
