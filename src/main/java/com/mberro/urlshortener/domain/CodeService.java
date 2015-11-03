package com.mberro.urlshortener.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by Marcus Berro on 24/10/15.
 */
@Component
public class CodeService {

    final static Logger log = LoggerFactory.getLogger(CodeService.class);

    public String nextCode(long seed){
        // TODO implement other algorithms hexadecimal so far
        return Long.toHexString(seed);
    }
}
