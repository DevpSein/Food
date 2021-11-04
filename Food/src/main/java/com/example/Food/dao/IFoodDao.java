package com.example.Food.dao;

import com.example.Food.entity.FoodEntity;
import com.example.Food.model.Food;

import java.util.List;

public interface IFoodDao {
    List<FoodEntity> getAllList() ;

    FoodEntity createOrUpdate(FoodEntity foodEntity);// içine mutlaka parametre verilmeli

    FoodEntity getById(Long id );


    }
//    List<Food> getList();
//
//    Food create (Food food);
//
//    Food update (Food food);
//
//    int delete (Integer id);