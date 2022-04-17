package com.example.Food.serviceimpl;

import com.example.Food.dao.IAuthDao;
import com.example.Food.entity.UserEntity;
import com.example.Food.model.dto.UserDto;
import com.example.Food.service.IAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements IAuthService {
    @Autowired
    private IAuthDao authDao ;
    @Override
    public UserEntity create(UserDto userDto) {
        UserEntity userEntity = new UserEntity();
        userEntity.setFirstName(userDto.getFirstName());
        userEntity.setLastName(userDto.getLastName());
        userEntity.setEmail(userDto.getEmail());
        userEntity.setPassword(userDto.getPassword());

        // UserEntity save =  authDao.register(userEntity);

        return authDao.register(userEntity);
    }

    @Override
    public UserEntity update(UserDto userDto) throws Exception {
        UserEntity user = authDao.getByUserId(userDto.getId());
        if (user == null){

            throw new Exception("Sistemde kayitli kullanici bulunamadı");
        }

        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());

        return authDao.update(user);

    }

    @Override
    public UserEntity getById(Long id) {
        return authDao.getByUserId(id);
    }

    @Override
    public String removeUser (Long id) {
        int result = authDao.removeById(id);

        return result == 1 ?"Islem başarılı.":"Islem basarisiz.";
    }



}
