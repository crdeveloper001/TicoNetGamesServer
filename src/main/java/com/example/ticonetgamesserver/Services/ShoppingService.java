package com.example.ticonetgamesserver.Services;

import com.example.ticonetgamesserver.Interfaces.IShopping;
import com.example.ticonetgamesserver.Models.ShoppingDTO;
import com.example.ticonetgamesserver.Repositories.ShoppingRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ShoppingService implements IShopping {

    @Autowired
    private ShoppingRepositories shoppingRepositories;

    public ShoppingService(ShoppingRepositories _ShoppingRepositories){

        this.shoppingRepositories = _ShoppingRepositories;
    }

    public ShoppingService(){}

    @Override
    public List<ShoppingDTO> AllShops() {

        try{

            if (shoppingRepositories.findAll().isEmpty()){

                return null;

            }else{
                return shoppingRepositories.findAll();
            }


            
            
        }catch (Exception errorGetList){
            throw  errorGetList;
        }
    }

    @Override
    public ShoppingDTO GenerateNewShop(ShoppingDTO shop) {

        try{
            //shop.setShopRegistrationData(new Date());
            shoppingRepositories.save(shop);

          return shop;

        }catch (Exception errorGenerateShop){

            throw errorGenerateShop;
        }

    }

    @Override
    public String UpdateShopInformation(ShoppingDTO update) {

        try{

            if (shoppingRepositories.existsById(update.get_id())){
                shoppingRepositories.save(update);

                return "Shop: " + update.get_id()+" Updated";
            }else{
                return "Shop not found! Please try again.";
            }

        }catch (Exception errorUpdateShop){

            return errorUpdateShop.getMessage();
        }
    }

    @Override
    public String DeleteShop(int id) {

        try{

            if (shoppingRepositories.existsById(id)){

                shoppingRepositories.deleteById(id);

                return "Shop Deleted";
            }else{

                return "Shop not found!";
            }

        }catch (Exception errorDeleteShop){

            return  errorDeleteShop.getMessage();
        }


    }
}
