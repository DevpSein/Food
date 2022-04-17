package com.example.Food.repository;

import com.example.Food.entity.FoodEntity;
import com.example.Food.model.Food;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IFoodRepository extends CrudRepository<FoodEntity , Long> {
    List<FoodEntity> findAll();
}
