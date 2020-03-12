package com.example.aquaone.web.advice;

import com.example.aquaone.to.BaseResponse;
import com.example.aquaone.util.exception.InvalidDataException;
import com.example.aquaone.util.exception.UserNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/**
 * Класс перехвата исключения при обработке REST-запросов.
 */
@RestControllerAdvice
public class ExceptionAdvice {
  private final Logger log = LoggerFactory.getLogger(getClass());

  /**
   * Обработка исключения отсутствия авторизации пользователя.
   */
  @ExceptionHandler(UserNotFoundException.class)
  @ResponseStatus(HttpStatus.UNAUTHORIZED)
  public StatusResponse handleNotAuthorizedException(final UserNotFoundException e) {
    log.error("User session was not found: {}", e.getMessage());
    return new StatusResponse().withData("UNAUTHORIZED")
        .withError("Пользователь не авторизован в системе");
  }

  /**
   * Обработка исключения при обработке данных REST-запроса.
   */
  @ExceptionHandler(InvalidDataException.class)
  @ResponseStatus(HttpStatus.OK)
  public StatusResponse handleInvalidDataException(final InvalidDataException e) {
    log.error("Invalid data error has occurred: {}", e.getMessage());
    return new StatusResponse().withData("INVALID_DATA_ERROR").withError(e.getMessage());
  }

  /**
   * Обработка прочих исключений REST-запроса.
   */
  @ExceptionHandler(Throwable.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public StatusResponse handleThrowable(final Throwable t) {
    log.error("Unexpected server error has occurred", t);
    return new StatusResponse().withData("INTERNAL_SERVER_ERROR")
        .withError("Проверьте введенные данные! Пользователь не найден!");
  }


  /**
   * Ответ на REST-запрос при возникновении исключения.
   */
  @SuppressWarnings("serial")
  public static class StatusResponse extends BaseResponse<String> {
  }

}
