package com.example.ticonetgamesserver.Interfaces;

import com.example.ticonetgamesserver.Models.CredentialsDTO;
import com.example.ticonetgamesserver.Models.UsersDTO;

import java.util.List;

public interface IAutentication {

    UsersDTO AuthenticateUser(CredentialsDTO credentials);
}
