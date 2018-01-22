package com.sample.appserver.hello;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by satoshi on 2018/01/21.
 */
@RestController
@RequestMapping(path="/user")
public class MainController {

  private static final Logger LOGGER = LoggerFactory.getLogger(MainController.class);

  @Autowired
  UserRepository userRepository;
  @Autowired
  TemporaryUserRepository temporaryUserRepository;

  @RequestMapping(method = POST, path = "/add", consumes = "application/json")
  public @ResponseBody String addNewUser (@RequestBody CreateUserRequest req) {
    LOGGER.info("Start /user/add");
    User u = new User();
    u.setUserId(req.userId);
    u.setEmail(req.email);
    u.setPassword(req.password);
    u.setSexuality(req.sexuality);
    u.setBirthYear(req.birth_year);
    u.setPrefecture(req.prefecture);
    userRepository.save(u);
    LOGGER.info("Saved User. userId:{}, email;{}", req.userId, req.email);

    TemporaryUser tu = new TemporaryUser();
    tu.setRegisterId(UUID.randomUUID().toString());
    tu.setUserId(req.userId);
    tu.setStatus("registered");
    temporaryUserRepository.save(tu);
    LOGGER.info("Saved TemporaryUser. registerId:{} userId:{}, email;{}", tu.getRegisterId(), tu.getUserId());

    return "saved\n";
  }

  @RequestMapping(method = GET, path = "/find")
  public @ResponseBody Iterable<User> getUserByEmail(@RequestParam String email) {
    LOGGER.info("Start /user/find with email {}", email);
    return userRepository.findByEmail(email);
  }

  @RequestMapping(method = GET, path = "/all")
  public @ResponseBody Iterable<User> getAllUsers() {
    // This returns a JSON or XML with the users
    return userRepository.findAll();
  }

}
