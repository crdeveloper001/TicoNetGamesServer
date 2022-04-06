package com.example.ticonetgamesserver.Services;

import com.example.ticonetgamesserver.Interfaces.IUsers;
import com.example.ticonetgamesserver.Models.UsersDTO;
import com.example.ticonetgamesserver.Repositories.UsersRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UsersService implements IUsers {

    @Autowired
    private UsersRepositories usersRepositories;

    public UsersService(UsersRepositories _UsersRepositories){

        this.usersRepositories = _UsersRepositories;
    }

    public UsersService(){}

    @Override
    public List<UsersDTO> ALlUsers() {

        try{

            if (usersRepositories.findAll().isEmpty()){

                return null;

            }else{
                return usersRepositories.findAll();
            }


            
            
        }catch (Exception errorGetList){
            throw  errorGetList;
        }
    }

    @Override
    public UsersDTO GenerateNewUser(UsersDTO user) {

        try{
            user.setUserRegistrationData(new Date());
          usersRepositories.save(user);

          return user;

        }catch (Exception errorGenerateUser){

            throw errorGenerateUser;
        }

    }

    @Override
    public String UpdateUserInformation(UsersDTO update) {

        try{

            if (usersRepositories.existsById(update.get_id())){
                usersRepositories.save(update);

                return "User: " + update.get_id()+" Updated";
            }else{
                return "user not found! please try again";
            }

        }catch (Exception errorUpdateUser){

            return errorUpdateUser.getMessage();
        }
    }

    @Override
    public String DeleteUserAccount(int id) {

        try{

            if (usersRepositories.existsById(id)){

                usersRepositories.deleteById(id);

                return "User Deleted";
            }else{

                return "User not found!";
            }

        }catch (Exception errorDeleteUser){

            return  errorDeleteUser.getMessage();
        }


    }
}
