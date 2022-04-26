package com.example.ticonetgamesserver.Interfaces;

import com.example.ticonetgamesserver.Models.ShoppingDTO;

import java.util.List;

public interface IShopping {

    List<ShoppingDTO> AllShops();

    ShoppingDTO GenerateNewShop(ShoppingDTO shop);

    String UpdateShopInformation(ShoppingDTO update);

    String DeleteShop(int id);

}
