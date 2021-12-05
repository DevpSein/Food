package com.example.Food.service;

import com.example.Food.entity.FoodEntity;
import com.example.Food.model.Food;
import com.example.Food.model.dto.FoodDto;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IFoodService {
    List<FoodEntity> getAllList();

    FoodEntity createOrUpdate(FoodDto foodDto);

    String deleteById (Long id) ;
}
//    List<Food> getList();
//
//    Food create (Food food);
//
//    Food update (Food Food);
//
//    String delete (Integer id);
