package com.example.Food.service;

import com.example.Food.entity.UserEntity;
import com.example.Food.model.dto.UserDto;

public interface IAuthService {
    UserEntity create (UserDto userDto);

    UserEntity update (UserDto userDto) throws  Exception ;

    UserEntity getById (Long id);

    String removeUser (Long id);

}
