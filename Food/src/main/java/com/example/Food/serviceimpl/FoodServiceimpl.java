package com.example.Food.serviceimpl;

import com.example.Food.dao.IFoodDao;
import com.example.Food.model.Food;
import com.example.Food.service.IFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
@Service
//Service'in altında genellikle database işlemleri olur controller katmanı service'le service katmanı ise dao ile haberleşir


public class FoodServiceimpl implements IFoodService {
    @Autowired
    private IFoodDao foodDao;


    @Override
    public List<Food> getList() {
        return foodDao.getList();
    }

    @Override
    public Food create(Food food) {
        Date newDate = new Date();
        String pattern = "dd-MMM-yyyy HH:mm";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(newDate);
        food.setCreateDate(date);
        return foodDao.create(food);
    }

    @Override
    public Food update(Food food) {
        Date newDate = new Date();
        String pattern = "dd-MMM-yyyy HH:mm";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(newDate);
        food.setLastModifiedDate(date);
        return foodDao.update(food);

    }

    @Override
    public String delete(Integer id) {
        int status = foodDao.delete(id);
        if(status == 1 ){
            return "islem basarılı";

        }
        return "islem basarısız";
    }
}
