package com.sample.appserver.hello;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by satoshi on 2018/01/21.
 */
@RestController
@RequestMapping(path="/demo")
public class MainController {

  private static final Logger LOGGER = LoggerFactory.getLogger(MainController.class);

  @Autowired
  UserRepository userRepository;

  @RequestMapping(method = POST, path = "/add")
  public @ResponseBody String addNewUser (@RequestParam String name, @RequestParam String email) {
    LOGGER.info("Start /demo/add");
    User u = new User();
    u.setName(name);
    u.setEmail(email);
    LOGGER.info("");
    userRepository.save(u);
    LOGGER.info("Saved name:{}, email;{}", name, email);
    return "saved\n";
  }

  @RequestMapping(method = GET, path = "/find")
  public @ResponseBody Iterable<User> getUserByEmail(@RequestParam String email) {
    LOGGER.info("Start /demo/find with email {}", email);
    return userRepository.findByEmail(email);
  }

  @RequestMapping(method = GET, path = "/all")
  public @ResponseBody Iterable<User> getAllUsers() {
    // This returns a JSON or XML with the users
    return userRepository.findAll();
  }

}
