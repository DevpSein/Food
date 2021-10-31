package com.example.Food.dao;

import com.example.Food.model.Food;

import java.util.List;

public interface IFoodDao {

    List<Food> getList();

    Food create (Food food);

    Food update (Food food);

    int delete (Integer id);

    }
