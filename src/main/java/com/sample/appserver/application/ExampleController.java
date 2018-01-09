package com.sample.appserver.application;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import com.sample.appserver.model.BCryptSample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by satoshi on 2017/12/27.
 */
@RestController
public class ExampleController {

  private final static Logger LOGGER = LoggerFactory.getLogger(ExampleController.class);
  @Autowired
  BCryptSample bcrypt;

  @RequestMapping(method = GET, path = "/example")
  public String example() {
    return "Hello Example!\n";
  }

  /**
   * Usage:
   *
   * <pre>
   *   $ curl -XPOST -s -H 'Content-type:application/json' -s http://localhost:8809/bcrypt -d
   * 'abcd1234'
   *   $2a$10$OIqS41bZDbBAaRM2rvAqHuGFQzR9ufMvtyWN7e/P7.n8eEkNNuQUG
   * </pre>
   *
   * @param msg a parameter to be encoded by BCrypt.
   * @return hashed msg.
   */
  @RequestMapping(method = POST, path = "/bcrypt")
  public String createHashByBCrypt(@RequestBody String msg) {
    LOGGER.info("/bcrypt message: {}", msg);
    return bcrypt.encodeByBCrypt(msg) + "\n";
  }
}
