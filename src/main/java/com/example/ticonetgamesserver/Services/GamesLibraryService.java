package com.example.ticonetgamesserver.Services;

import com.example.ticonetgamesserver.Interfaces.IGamesLibrary;
import com.example.ticonetgamesserver.Models.GamesDTO;
import com.example.ticonetgamesserver.Models.GamesLibraryDTO;
import com.example.ticonetgamesserver.Repositories.GamesLibraryRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GamesLibraryService implements IGamesLibrary {

    @Autowired
    private GamesLibraryRepositories gamesLibraryRepositories;

    public GamesLibraryService (GamesLibraryRepositories _repositorie) {
        this.gamesLibraryRepositories = _repositorie;
    }

    public GamesLibraryService(){}

    @Override
    public List<GamesLibraryDTO> AllMyGames() {
     try{

         return this.gamesLibraryRepositories.findAll();

     }catch (Exception errorLibraryGames){

         throw errorLibraryGames;

     }
    }
    @Override
    public GamesLibraryDTO AddGameToLibrary(GamesLibraryDTO game) {
        try{

            gamesLibraryRepositories.save(game);

            return game;

        }catch (Exception errorGenerateGame){

            throw errorGenerateGame;
        }
    }

    @Override
    public String DeleteGameLibrary(int id) {
        try{

            if (gamesLibraryRepositories.existsById(id)){

                gamesLibraryRepositories.deleteById(id);

                return "Game Deleted";
            }else{

                return "Game not found!";
            }

        }catch (Exception errorDeleteShop){

            return  errorDeleteShop.getMessage();
        }
    }
}
