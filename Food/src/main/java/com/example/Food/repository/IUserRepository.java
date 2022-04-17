package com.example.Food.repository;

import com.example.Food.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface IUserRepository extends CrudRepository <UserEntity,Long> {

}
