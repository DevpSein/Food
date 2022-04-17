package com.example.Food.daoimpl;

import com.example.Food.dao.IAuthDao;
import com.example.Food.entity.UserEntity;
import com.example.Food.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthDaoImpl implements IAuthDao {
    @Autowired
    private IUserRepository userRepository ;
    @Override
    public UserEntity register(UserEntity userEntity) {
        UserEntity user = userRepository.save(userEntity);
        return user;
    }

    @Override
    public UserEntity update(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

    @Override
    public UserEntity getByUserId(Long id) {

        return userRepository.findById(id).get();
    }

    @Override
    public int removeById(Long id) {
        userRepository.deleteById(id);
        return 1;
    }
}
