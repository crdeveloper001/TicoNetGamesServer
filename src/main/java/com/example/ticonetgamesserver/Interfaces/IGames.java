package com.example.ticonetgamesserver.Interfaces;

import com.example.ticonetgamesserver.Models.GamesDTO;

import java.util.List;

public interface IGames {

    List<GamesDTO> AllGames();

    GamesDTO GenerateNewGame(GamesDTO game);

    String UpdateGameInformation(GamesDTO update);

    String DeleteGame(int id);

}
