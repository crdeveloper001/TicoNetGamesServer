package com.example.ticonetgamesserver.Services;

import com.example.ticonetgamesserver.Interfaces.IGames;
import com.example.ticonetgamesserver.Models.GamesDTO;
import com.example.ticonetgamesserver.Repositories.GamesRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class GamesService implements IGames {

    @Autowired
    private GamesRepositories gamesRepositories;

    public GamesService(GamesRepositories _GamesRepositories){

        this.gamesRepositories = _GamesRepositories;
    }

    public GamesService(){}

    @Override
    public List<GamesDTO> AllGames() {

        try{

            if (gamesRepositories.findAll().isEmpty()){

                return null;

            }else{
                return gamesRepositories.findAll();
            }


            
            
        }catch (Exception errorGetList){
            throw  errorGetList;
        }
    }

    @Override
    public GamesDTO GenerateNewGame(GamesDTO game) {

        try{
            //0game.setGameRegistrationData(new Date());
            gamesRepositories.save(game);

          return game;

        }catch (Exception errorGenerateGame){

            throw errorGenerateGame;
        }

    }

    @Override
    public String UpdateGameInformation(GamesDTO update) {

        try{

            if (gamesRepositories.existsById(update.get_id())){
                gamesRepositories.save(update);

                return "Game: " + update.get_id()+" Updated";
            }else{
                return "Game not found! Please try again.";
            }

        }catch (Exception errorUpdateShop){

            return errorUpdateShop.getMessage();
        }
    }

    @Override
    public String DeleteGame(int id) {

        try{

            if (gamesRepositories.existsById(id)){

                gamesRepositories.deleteById(id);

                return "Game Deleted";
            }else{

                return "Game not found!";
            }

        }catch (Exception errorDeleteShop){

            return  errorDeleteShop.getMessage();
        }


    }
}
