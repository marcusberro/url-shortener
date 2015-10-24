package com.mberro.urlshortener.domain;

import com.mberro.urlshortener.application.ShortenerApplicationService;
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
        final Optional<ShortenUrl> shortenUrl = shortenerRepository.findByCode(code);

        if(!shortenUrl.isPresent()) {
            // TODO throuws exception
        }

        shortenUrl.get().increaseHits();

        redirectionRepository.save(new Redirection(shortenUrl.get(), new SourceInfo(requestInfo)));

        return shortenUrl.get().getUrl();
    }
}