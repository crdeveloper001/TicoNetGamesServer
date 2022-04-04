package com.example.ticonetgamesserver.Repositories;

import com.example.ticonetgamesserver.Models.GamesDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GamesRepositories extends MongoRepository<GamesDTO, Integer> {
}
