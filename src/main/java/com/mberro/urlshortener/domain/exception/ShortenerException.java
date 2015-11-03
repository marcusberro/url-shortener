package com.mberro.urlshortener.domain.exception;

import org.springframework.http.HttpStatus;

/**
 * Created by Marcus Berro on 01/11/15.
 */
public class ShortenerException extends RuntimeException{

    private String key;
    private HttpStatus httpErrorCode;

    public ShortenerException(String key, HttpStatus httpErrorCode) {
        setKey(key);
        setHttpErrorCode(httpErrorCode);
    }

    public HttpStatus getHttpErrorCode() {
        return httpErrorCode;
    }

    private void setHttpErrorCode(HttpStatus httpErrorCode) {
        this.httpErrorCode = httpErrorCode;
    }

    public String getKey() {
        return key;
    }

    private void setKey(String key) {
        this.key = key;
    }
}