package com.example.ticonetgamesserver.Repositories;

import com.example.ticonetgamesserver.Models.ShoppingDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingRepositories extends MongoRepository<ShoppingDTO,Integer> {
}
