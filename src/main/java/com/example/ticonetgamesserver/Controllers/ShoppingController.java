package com.example.ticonetgamesserver.Controllers;

import com.example.ticonetgamesserver.Models.ShoppingDTO;
import com.example.ticonetgamesserver.Services.ShoppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*")
@RequestMapping(path = "api/v1/Shopping")
public class ShoppingController {

    @Autowired
    private ShoppingService shoppingService;

    @GetMapping()
    public ResponseEntity<?> GetShop(){

        return new ResponseEntity<>(shoppingService.AllShops(), HttpStatus.OK);
    }

    @PostMapping()
    @ResponseBody
    public ResponseEntity<?> PostShop(@RequestBody ShoppingDTO shop){

        return new ResponseEntity<>(shoppingService.GenerateNewShop(shop),HttpStatus.CREATED);

    }
    @PutMapping()
    public ResponseEntity<?> PutShop(@RequestBody ShoppingDTO shopInfo){

        return new ResponseEntity<>(shoppingService.UpdateShopInformation(shopInfo),HttpStatus.CREATED);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<?> DeleteShop(@PathVariable int id){

        return new ResponseEntity<>(shoppingService.DeleteShop(id),HttpStatus.OK);
    }


}
