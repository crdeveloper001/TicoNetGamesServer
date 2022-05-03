package com.example.ticonetgamesserver.Controllers;

import com.example.ticonetgamesserver.Models.GamesDTO;
import com.example.ticonetgamesserver.Models.GamesLibraryDTO;
import com.example.ticonetgamesserver.Services.GamesLibraryService;
import com.example.ticonetgamesserver.Services.GamesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*")
@RequestMapping("GamesLibraryService")
public class GamesLibraryController {

    @Autowired
    private GamesLibraryService gamesLibraryService;

    @GetMapping("GetGamesLibrary")
    public ResponseEntity<?> GetGames(){

        return new ResponseEntity<>(gamesLibraryService.AllMyGames(), HttpStatus.OK);
    }

    @PostMapping("CreateGameLibrary")
    @ResponseBody
    public ResponseEntity<?> PostGame(@RequestBody GamesLibraryDTO game){

        return new ResponseEntity<>(gamesLibraryService.AddGameToLibrary(game),HttpStatus.CREATED);

    }
    @DeleteMapping("DeleteGameLibrary/{id}")
    public ResponseEntity<?> DeleteGame(@PathVariable int id){

        return new ResponseEntity<>(gamesLibraryService.DeleteGameLibrary(id),HttpStatus.OK);
    }

}
