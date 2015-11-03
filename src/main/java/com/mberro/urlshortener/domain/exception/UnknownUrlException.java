package com.mberro.urlshortener.domain.exception;

import org.springframework.http.HttpStatus;

/**
 * Created by Marcus Berro on 01/11/15.
 */
public class UnknownUrlException extends ShortenerException {

    public UnknownUrlException() {
        super("UNKNOWN_URL", HttpStatus.NOT_FOUND);
    }

}
