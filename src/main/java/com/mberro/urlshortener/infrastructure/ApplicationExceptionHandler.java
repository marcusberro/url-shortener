package com.mberro.urlshortener.infrastructure;

import com.mberro.urlshortener.domain.exception.ErrorInfo;
import com.mberro.urlshortener.domain.exception.ShortenerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by Marcus Berro on 02/11/15.
 */
@ControllerAdvice
public class ApplicationExceptionHandler {

    private static final Logger LOG = LoggerFactory.getLogger(ApplicationExceptionHandler.class);

    @ExceptionHandler(ShortenerException.class)
    @ResponseBody
    ErrorInfo handleRestException(HttpServletResponse response, ShortenerException ex) {
        LOG.error("Returning [" + ex.getHttpErrorCode() + "] " + ex.getMessage());
        response.setStatus(ex.getHttpErrorCode().value());
        return new ErrorInfo(ex.getMessage(), ex.getHttpErrorCode(), ex.getKey());
    }
}