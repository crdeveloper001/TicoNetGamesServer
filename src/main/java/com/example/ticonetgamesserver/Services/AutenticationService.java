package com.example.ticonetgamesserver.Services;

import com.example.ticonetgamesserver.Interfaces.IAutentication;
import com.example.ticonetgamesserver.Models.CredentialsDTO;
import com.example.ticonetgamesserver.Models.UsersDTO;
import com.example.ticonetgamesserver.Repositories.UsersRepositories;
import com.example.ticonetgamesserver.Utilities.JwtGeneration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutenticationService implements IAutentication {

    @Autowired
    private JwtGeneration getJWTToken;

    @Autowired
    private UsersRepositories usersRepositories;

    @Override
    public UsersDTO AuthenticateUser(CredentialsDTO credentials) {

        // buscar usuario especifico
        UsersDTO UserInformationGeneral = new UsersDTO();
        UserInformationGeneral = usersRepositories.getUserInformationByMail(credentials.getMail());

        // variables globales para todos los usuarios
        // List<UsersDTO> userDBContext = null;
        // userDBContext = usersRepositories.findAll();

        if (credentials.getMail().equals(UserInformationGeneral.getMail())
                && credentials.getPassword().equals(UserInformationGeneral.getPassword())) {

            String token = getJWTToken.GetAccessToken(credentials.getMail());

            UsersDTO UserSuccessPayload = new UsersDTO();
            UserSuccessPayload.setName(UserInformationGeneral.getName());
            UserSuccessPayload.setMail(UserInformationGeneral.getMail());
            UserSuccessPayload.setPhone(UserInformationGeneral.getPhone());
            UserSuccessPayload.set_id(UserInformationGeneral.get_id());
            UserSuccessPayload.setRole(UserInformationGeneral.getRole());
            UserSuccessPayload.setPassword(token);

            return UserSuccessPayload;

        } else {

            return null;
        }

    }
}
