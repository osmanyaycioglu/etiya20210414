package com.training.micro.validation.security.user.repo;

import org.springframework.data.repository.CrudRepository;

import com.training.micro.validation.security.user.UserObject;

public interface IUserDao extends CrudRepository<UserObject, Long> {


}
