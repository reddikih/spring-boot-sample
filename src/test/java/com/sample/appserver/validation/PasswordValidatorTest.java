package com.sample.appserver.validation;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * Created by satoshi on 2018/01/08.
 */
public class PasswordValidatorTest {

  @Test
  public void isValid_validPassword_returnTrue() throws Exception {
    // SetUp
    PasswordValidator sut = new PasswordValidator();

    // Exercise & Verify
    assertThat(sut.isValid("a1", null), is(true));
    assertThat(sut.isValid("a!", null), is(true));
    assertThat(sut.isValid("1!", null), is(true));
    assertThat(sut.isValid("1!", null), is(true));
    assertThat(sut.isValid("a1!", null), is(true));
  }

  @Test
  public void isValid_invalidPassword_returnFalse() throws Exception {
    // SetUp
    PasswordValidator sut = new PasswordValidator();

    // Exercise & Verify
    assertThat(sut.isValid(null, null), is(false));
    assertThat(sut.isValid("", null), is(false));
    assertThat(sut.isValid("a", null), is(false));
    assertThat(sut.isValid("1", null), is(false));
    assertThat(sut.isValid("!", null), is(false));
    assertThat(sut.isValid("abc", null), is(false));
    assertThat(sut.isValid("123", null), is(false));
    assertThat(sut.isValid("!@#$%^&*()_+=-{}\\\\[\\\\]~`;:?|\\\\/,.\\\"'<>", null), is(false));
  }

}