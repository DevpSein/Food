package com.example.Food.controller;
import com.example.Food.entity.FoodEntity;
import com.example.Food.model.Food;
import com.example.Food.model.dto.FoodDto;
import com.example.Food.service.IFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import java.util.List;
// Controller katmanında clientle haberleşme
@RestController
@RequestMapping(value = "/api/food",produces = "application/json")

public class FoodController {
    //test
    @Qualifier("foodServiceimpl")
    @Autowired // Autowired bir bean yönetimidir.Spring konfigürasyon dosyasında birden fazla değer atama yaparsak spring bu tanımlamalardan hangisinin kullnaılacağına qualifer anatosyonu ile karar verir.
    private IFoodService foodService;

    @RequestMapping(value = "createOrUpdate", method = RequestMethod.POST)
    public FoodEntity create(@RequestBody FoodDto foodDto) {
        return foodService.createOrUpdate(foodDto);
    }
    @RequestMapping(value = "allList",method = RequestMethod.GET)
    public List<FoodEntity> getAllList(){
        return foodService.getAllList();
    }
    @RequestMapping(value ="{id}",method = RequestMethod.DELETE)
    public String delete(@PathVariable Long id){
            return   foodService.deleteById(id);
    }
}


/*
@RequestMapping(value =  "list", method = RequestMethod.GET)
    public List<Food> getList(){
        return foodService.getList();

    @RequestMapping(value = "create",method = RequestMethod.POST)
   public Food create(@RequestBody Food food){
        return foodService.create(food);
   }
   @RequestMapping (value = "update",method = RequestMethod.PUT)
   public Food update(@RequestBody Food food){
        return foodService.update(food);
   }
   @RequestMapping (value = "delete", method = RequestMethod.DELETE)
   public String delete (@PathVariable Integer id){
        return foodService.delete(id);

    }*/
