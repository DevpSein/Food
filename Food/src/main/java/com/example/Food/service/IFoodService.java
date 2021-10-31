package com.example.Food.service;

import com.example.Food.model.Food;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IFoodService {
    List<Food> getList();

    Food create (Food food);

    Food update (Food Food);

    String delete (Integer id);
}
