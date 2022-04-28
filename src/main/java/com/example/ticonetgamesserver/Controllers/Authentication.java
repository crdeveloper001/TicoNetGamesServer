package com.example.ticonetgamesserver.Controllers;

import com.example.ticonetgamesserver.Models.CredentialsDTO;
import com.example.ticonetgamesserver.Models.UsersDTO;
import com.example.ticonetgamesserver.Services.AutenticationService;
import com.example.ticonetgamesserver.Utilities.JwtGeneration;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*")
@RequestMapping("AuthenticationServer")
public class Authentication {

    @Autowired
    private AutenticationService _autenticationService;

    @PostMapping()
    @ResponseBody
    public ResponseEntity<?> login(@RequestBody CredentialsDTO credentials) {

        UsersDTO validationPayload = new UsersDTO();

        validationPayload = _autenticationService.AuthenticateUser(credentials);


        if (validationPayload != null){

            return new ResponseEntity<>(validationPayload,HttpStatus.OK);

        }else if( validationPayload == null){

            return new ResponseEntity<>("EL usuario es incorrecto o no esta registrado en la base de datos",HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>("Ocurrio un error al autenticar!! o su solicitud no es valida",HttpStatus.FORBIDDEN);
        }




    }


}
