package com.example.ticonetgamesserver.Repositories;

import com.example.ticonetgamesserver.Models.UsersDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.awt.print.Book;
import java.util.List;

@Repository
public interface UsersRepositories extends MongoRepository<UsersDTO, Integer> {

    @Query("{Mail : ?0}")
    UsersDTO getUserInformationByMail(String mail);
}
