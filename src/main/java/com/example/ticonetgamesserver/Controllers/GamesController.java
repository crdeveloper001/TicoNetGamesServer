package com.example.ticonetgamesserver.Controllers;

import com.example.ticonetgamesserver.Models.GamesDTO;
import com.example.ticonetgamesserver.Services.GamesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*")
@RequestMapping(path = "Games")
public class GamesController {

    @Autowired
    private GamesService gamesService;

    @GetMapping("GetGames")
    public ResponseEntity<?> GetGames(){

        return new ResponseEntity<>(gamesService.AllGames(), HttpStatus.OK);
    }

    @PostMapping("CreateGame")
    @ResponseBody
    public ResponseEntity<?> PostGame(@RequestBody GamesDTO game){

        return new ResponseEntity<>(gamesService.GenerateNewGame(game),HttpStatus.CREATED);

    }
    @PutMapping("UpdateGame")
    public ResponseEntity<?> PutGame(@RequestBody GamesDTO gameInfo){

        return new ResponseEntity<>(gamesService.UpdateGameInformation(gameInfo),HttpStatus.CREATED);
    }
    @DeleteMapping("DeleteGame/{id}")
    public ResponseEntity<?> DeleteGame(@PathVariable int id){

        return new ResponseEntity<>(gamesService.DeleteGame(id),HttpStatus.OK);
    }


}
