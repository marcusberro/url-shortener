package com.mberro.urlshortener.domain;

import com.mberro.urlshortener.domain.exception.UnknownUrlException;
import com.mberro.urlshortener.domain.repository.RedirectionRepository;
import com.mberro.urlshortener.domain.repository.ShortenerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;

/**
 * Created by Marcus Berro on 24/10/15.
 */
@Component
public class ShortenerService {

    static Logger log = LoggerFactory.getLogger(ShortenerService.class);

    @Autowired
    private ShortenerRepository shortenerRepository;

    @Autowired
    private RedirectionRepository redirectionRepository;

    @Autowired
    private CodeService codeService;

    public ShortenUrl shorten(String url){
        ShortenUrl shortenUrl = new ShortenUrl(url);
        shortenUrl.shorten(codeService, shortenerRepository);
        return shortenUrl;
    }

    public String getRedirectionUrl(String code, Map<String, String> requestInfo) {
        // TODO validate if (StringUtils.isAlpha(code)) {
        final Optional<ShortenUrl> shortenUrl = shortenerRepository.findByCode(code);

        if(!shortenUrl.isPresent())
            throw new UnknownUrlException();

        shortenUrl.get().increaseHits();

        // TODO review ShortenUrl responsibility related to redirection
        redirectionRepository.save(new Redirection(shortenUrl.get(), new SourceInfo(requestInfo)));

        log.info("Redirecting code["+code+"] url["+shortenUrl.get().getUrl()+"]");

        return shortenUrl.get().getUrl();
    }
}