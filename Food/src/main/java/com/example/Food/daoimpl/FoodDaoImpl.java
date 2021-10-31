package com.example.Food.daoimpl;

import com.example.Food.dao.IFoodDao;
import com.example.Food.model.Food;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Component
public class FoodDaoImpl implements IFoodDao {
    public static List<Food> foods = new ArrayList<>();
    public static int i = 0 ;

    @Override
    public List<Food> getList() {
        return foods;
    }

    @Override
    public Food create(Food food) {
        Date newDate = new Date();
        i = i+1;
        food.setId(i);
        foods.add(food);
        return food;
    }

    @Override
    public Food update(Food food) {
        for (Food item : foods){
            if (item.getId() == food.getId()){
                item.setTitle(food.getTitle());
                item.setDescription(food.getDescription());
                item.setList(food.getList());
                item.setLastModifiedDate(food.getLastModifiedDate());

            }

        }
        return food;
    }

    @Override
    public int delete(Integer id) {
        int index = -1;
        for (int i = 0 ;i< foods.size();i++){
            if (foods.get(i).getId() == id){
                index = i ;
                break;
            }

        }
        if (index != -1){
            foods.remove(index);
            return 1; // başarılı ise 1 değeri döner
        }

        return 0;
    }
}
