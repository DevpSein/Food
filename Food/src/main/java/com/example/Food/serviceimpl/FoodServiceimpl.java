package com.example.Food.serviceimpl;

import com.example.Food.dao.IAuthDao;
import com.example.Food.dao.IFoodDao;
import com.example.Food.entity.FoodEntity;
import com.example.Food.entity.UserEntity;
import com.example.Food.model.Food;
import com.example.Food.model.dto.FoodDto;
import com.example.Food.service.IAuthService;
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

    @Autowired
    private IAuthDao authDao;


    @Override
    public List<FoodEntity> getAllList() {
        return foodDao.getAllList();
    }

    @Override
    public FoodEntity createOrUpdate(FoodDto foodDto) {
        FoodEntity foodEntity = null;
        if(foodDto.getId() != null) { // id içi boş değilse güncelleme
            foodEntity = foodDao.getById(foodDto.getId());
        }else {
            foodEntity = new FoodEntity();
            foodEntity.setCreateDate(new Date());
        }
        foodEntity.setTitle(foodDto.getTitle());
        foodEntity.setDescription(foodDto.getDescription());
        foodEntity.setFoodDetails(foodDto.getFoodDetails());

        UserEntity currentUser = authDao.getByUserId(foodDto.getUserId());
        foodEntity.setUser(currentUser);
        return foodDao.createOrUpdate(foodEntity);


    }

    @Override
    public String deleteById(Long id) {
        int result = foodDao.removeById(id);
        return result ==1?"Islem Basarili":"Islem Basarisiz";
    }
}
//    @Override
//    public List<Food> getList() {
//        return foodDao.getList();
//    }
//
//    @Override
//    public Food create(Food food) {
//        Date newDate = new Date();
//        String pattern = "dd-MMM-yyyy HH:mm";
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
//        String date = simpleDateFormat.format(newDate);
//        food.setCreateDate(date);
//        return foodDao.create(food);
//    }
//
//    @Override
//    public Food update(Food food) {
//        Date newDate = new Date();
//        String pattern = "dd-MMM-yyyy HH:mm";
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
//        String date = simpleDateFormat.format(newDate);
//        food.setLastModifiedDate(date);
//        return foodDao.update(food);
//
//    }
//
//    @Override
//    public String delete(Integer id) {
//        int status = foodDao.delete(id);
//        if(status == 1 ){
//            return "islem basarılı";
//
//        }
//        return "islem basarısız";
//    }
