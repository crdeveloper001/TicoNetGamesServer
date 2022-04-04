package com.example.ticonetgamesserver.Controllers;

import com.example.ticonetgamesserver.Models.CredentialsDTO;
import com.example.ticonetgamesserver.Models.UsersDTO;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.catalina.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/AuthenticationServer")
public class Authentication {

    @GetMapping()
    public ResponseEntity<?> GetUser(){
        return new ResponseEntity<>("Hello World", HttpStatus.OK);
    }

    @PostMapping("user")
    public CredentialsDTO login(@RequestBody CredentialsDTO credentials) {

        String token = getJWTToken(credentials.getEmail());
        CredentialsDTO payload = new CredentialsDTO();
        payload.setEmail(credentials.getEmail());
        payload.setPass(token);
        return credentials;

    }

    private String getJWTToken(String username) {
        String secretKey = "mySecretKey";
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ROLE_USER");

        String token = Jwts
                .builder()
                .setId("softtekJWT")
                .setSubject(username)
                .claim("authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 600000))
                .signWith(SignatureAlgorithm.HS512,
                        secretKey.getBytes()).compact();

        return "Bearer " + token;
    }
}
