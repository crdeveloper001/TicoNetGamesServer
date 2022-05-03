package com.example.ticonetgamesserver.Interfaces;

import com.example.ticonetgamesserver.Models.GamesDTO;
import com.example.ticonetgamesserver.Models.GamesLibraryDTO;

import java.util.List;

public interface IGamesLibrary {
    List<GamesLibraryDTO> AllMyGames();

    GamesLibraryDTO AddGameToLibrary(GamesLibraryDTO game);

    String DeleteGameLibrary(int id);
}
