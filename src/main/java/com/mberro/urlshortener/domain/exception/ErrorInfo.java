package com.mberro.urlshortener.domain.exception;

import org.springframework.http.HttpStatus;

/**
 * Created by Marcus Berro on 02/11/15.
 */
public class ErrorInfo {

    private String message;

    private HttpStatus httpErrorCode;

    private String key;

    public ErrorInfo(String message, HttpStatus httpErrorCode, String key) {
        setMessage(message);
        setHttpErrorCode(httpErrorCode);
        setKey(key);
    }

    private void setMessage(String message) {
        this.message = message;
    }

    private void setHttpErrorCode(HttpStatus httpErrorCode) {
        this.httpErrorCode = httpErrorCode;
    }

    private void setKey(String key) {
        this.key = key;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpErrorCode() {
        return httpErrorCode;
    }

    public String getKey() {
        return key;
    }

    @Override
    public String toString() {
        return "ErrorInfo{" +
                "message='" + message + '\'' +
                ", httpErrorCode=" + httpErrorCode +
                ", key='" + key + '\'' +
                '}';
    }
}
