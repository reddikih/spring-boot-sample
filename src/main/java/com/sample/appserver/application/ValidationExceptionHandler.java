package com.sample.appserver.application;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Created by satoshi on 2018/01/08.
 */
@ControllerAdvice
public class ValidationExceptionHandler extends ResponseEntityExceptionHandler {

  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
      HttpHeaders headers, HttpStatus status, WebRequest request) {
    BindingResult bindingResult = ex.getBindingResult();

    List<ApiFieldError> fieldErrors = bindingResult.getFieldErrors().stream()
        .map(fe -> new ApiFieldError(
            fe.getField(),
            fe.getCode(),
            fe.getRejectedValue(),
            fe.getDefaultMessage()
        )).collect(Collectors.toList());

    ApiErrorsView errorsView = new ApiErrorsView(fieldErrors);
    return new ResponseEntity<>(errorsView, HttpStatus.UNPROCESSABLE_ENTITY);
  }

  public static class ApiErrorsView {

    public List<ApiFieldError> fieldErrors;

    public ApiErrorsView(List<ApiFieldError> fieldErrors) {
      this.fieldErrors = fieldErrors;
    }
  }

  public static class ApiFieldError {

    public String field;
    public String code;
    public Object rejectedValue;
    public String message;

    public ApiFieldError(String field, String code, Object rejectedValue, String message) {
      this.field = field;
      this.code = code;
      this.rejectedValue = rejectedValue;
      this.message = message;
    }
  }

}
