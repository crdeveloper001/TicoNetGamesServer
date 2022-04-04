package com.example.ticonetgamesserver.Repositories;

import com.example.ticonetgamesserver.Models.UsersDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepositories extends MongoRepository<UsersDTO, Integer> {
}
