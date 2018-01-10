package com.sample.appserver.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by satoshi on 2018/01/08.
 */
public class PasswordValidator implements ConstraintValidator<Password, String> {

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    if (value == null || value.length() == 0) {
      return false;
    }

    int usedCharType = 0;

    if (value.matches(".*[0-9]+.*")) {
      usedCharType++;
    }
    if (value.matches(".*[a-zA-Z]+.*")) {
      usedCharType++;
    }
    if (value.matches(".*[!@#$%^&*()_+=\\[\\]~`;:?|\\/,.\"'<>{}-]+.*")) {
      usedCharType++;
    }

    return usedCharType >= 2;
  }

}
