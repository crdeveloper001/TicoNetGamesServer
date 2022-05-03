package com.example.ticonetgamesserver.Controllers;

import com.example.ticonetgamesserver.Models.ShoppingDTO;
import com.example.ticonetgamesserver.Services.ShoppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*")
@RequestMapping(path = "Shoppings")
public class ShoppingController {

    @Autowired
    private ShoppingService shoppingService;

    @GetMapping("GetShopCart")
    public ResponseEntity<?> GetShop(){

        return new ResponseEntity<>(shoppingService.AllShops(), HttpStatus.OK);
    }

    @PostMapping("CreateShopCart")
    @ResponseBody
    public ResponseEntity<?> PostShop(@RequestBody ShoppingDTO shop){

        return new ResponseEntity<>(shoppingService.GenerateNewShop(shop),HttpStatus.CREATED);

    }
    @PutMapping("UpdateShopCart")
    public ResponseEntity<?> PutShop(@RequestBody ShoppingDTO shopInfo){

        return new ResponseEntity<>(shoppingService.UpdateShopInformation(shopInfo),HttpStatus.CREATED);
    }
    @DeleteMapping("DeleteShoppingCart/{id}")
    public ResponseEntity<?> DeleteShop(@PathVariable int id){

        return new ResponseEntity<>(shoppingService.DeleteShop(id),HttpStatus.OK);
    }


}
