package hr.apisit.arsen.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class FileException extends RuntimeException {

  public FileException(String message) {
    super(message);
  }

  public FileException(String message, Throwable cause) {
    super(message, cause);
  }

  public FileException(Throwable cause) {
    super(cause);
  }

  public FileException(String message, Throwable cause, boolean enableSuppression,
      boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
