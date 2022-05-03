package com.example.ticonetgamesserver.Repositories;

import com.example.ticonetgamesserver.Models.GamesLibraryDTO;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GamesLibraryRepositories extends MongoRepository<GamesLibraryDTO,Integer> {
}
