package com.sample.appserver.hello;

import java.util.UUID;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by satoshi on 2018/01/22.
 */
public interface TemporaryUserRepository extends CrudRepository<TemporaryUser, UUID> {

}
