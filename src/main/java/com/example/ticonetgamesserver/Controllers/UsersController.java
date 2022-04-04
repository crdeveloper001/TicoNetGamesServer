package com.example.ticonetgamesserver.Controllers;

import com.example.ticonetgamesserver.Models.UsersDTO;
import com.example.ticonetgamesserver.Services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*")
@RequestMapping(path = "api/v1/Users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @GetMapping()
    public ResponseEntity<?> GetUsers(){

        return new ResponseEntity<>(usersService.ALlUsers(), HttpStatus.OK);
    }

    @PostMapping()
    @ResponseBody
    public ResponseEntity<?> PostUser(@RequestBody UsersDTO user){

        return new ResponseEntity<>(usersService.GenerateNewUser(user),HttpStatus.CREATED);

    }
    @PutMapping()
    public ResponseEntity<?> PutUser(@RequestBody UsersDTO userInfo){

        return new ResponseEntity<>(usersService.UpdateUserInformation(userInfo),HttpStatus.CREATED);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<?> DeleteUser(@PathVariable int id){

        return new ResponseEntity<>(usersService.DeleteUserAccount(id),HttpStatus.OK);
    }


}
