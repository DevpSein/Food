package com.example.Food.controller;

import com.example.Food.entity.UserEntity;
import com.example.Food.model.dto.UserDto;
import com.example.Food.service.IAuthService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// clientle haberleştiğimiz katman
@RestController
@RequestMapping(value ="/api/auth", produces = "application/json")
public class AuthController {
    @Autowired
    private IAuthService authService;

    @RequestMapping(value = "register",method = RequestMethod.POST)
    public UserEntity register(@RequestBody UserDto userDto){
        return authService.create(userDto);
    }
    @RequestMapping(value = "update",method = RequestMethod.POST)
    public UserEntity update (@RequestBody UserDto userDto) throws Exception {
        return authService.update(userDto);
    }
    @RequestMapping(value = "{id}",method = RequestMethod.DELETE)
    public String delete(@PathVariable Long id ){
        return authService.removeUser(id);

    }

}
