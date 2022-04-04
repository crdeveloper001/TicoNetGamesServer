package com.example.ticonetgamesserver.Interfaces;

import com.example.ticonetgamesserver.Models.UsersDTO;

import java.util.List;

public interface IUsers {

    List<UsersDTO> ALlUsers();

    UsersDTO GenerateNewUser(UsersDTO user);

    String UpdateUserInformation(UsersDTO update);

    String DeleteUserAccount(int id);

}
