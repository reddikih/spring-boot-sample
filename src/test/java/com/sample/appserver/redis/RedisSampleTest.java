package com.sample.appserver.redis;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.*;

import java.util.UUID;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by satoshi on 2018/01/22.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisSampleTest {

  @Autowired
  RedisSample sut;

  @Test
  public void basic_run_putAndGetValues() throws Exception {
    // Setup
    String key = UUID.randomUUID().toString();
    String value = "0123";
    Long timeout = 5L;

    // Exercise
    sut.put(key, value, timeout);

    // Verify
    String actual = sut.get(key);
    assertThat(actual, is(value));
    Thread.sleep(10000L);
    String expired = sut.get(key);
    assertThat(expired, is(nullValue()));
  }
}