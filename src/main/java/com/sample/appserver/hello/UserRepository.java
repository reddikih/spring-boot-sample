package com.sample.appserver.hello;

import java.util.List;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by satoshi on 2018/01/21.
 */
/*
 * This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
 * CRUD refers Create, Read, Update, Delete
 */
public interface UserRepository extends CrudRepository<User, UUID> {

  public List<User> findByEmail(String email);

}
