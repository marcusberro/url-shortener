package com.mberro.urlshortener.presentation;

import com.mberro.urlshortener.application.ShortenerApplicationService;
import com.mberro.urlshortener.application.representation.ShortenResponse;
import com.mberro.urlshortener.domain.ShortenUrl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Marcus Berro on 31/10/15.
 */
@RestController
public class ShortenerController {

    final static Logger log = LoggerFactory.getLogger(ShortenerController.class);

    @Autowired
    private ShortenerApplicationService shortenerApplicationService;

    @RequestMapping(path = "/", method = RequestMethod.POST)
    @ResponseBody
    public ShortenResponse shorten(@RequestBody String url, HttpServletRequest request) throws IOException {
        return shortenerApplicationService.shorten(url);
    }

    @RequestMapping(path = "/shorten-urls", method = RequestMethod.GET)
    public List<ShortenUrl> listShortenUrls() {
        return shortenerApplicationService.listShortenUrls();
    }

    @RequestMapping(path = "/{code}", method = RequestMethod.GET)
    public void redirect(@PathVariable String code, HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect(shortenerApplicationService.getRedirectionUrl(code, getSourceInfoMap(request)));
    }

    // TODO build web app to show and create shorten URLs
    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String helloWorld() {
        return "Home";
    }

    private Map<String, String> getSourceInfoMap(HttpServletRequest request) {
        Map<String, String> sourceInfo = new HashMap<>();
        sourceInfo.put("userAgent", request.getHeader("User-Agent"));
        sourceInfo.put("sourceHost",request.getHeader("Host"));
        sourceInfo.put("sourceRequestDate", request.getHeader("Date"));
        return sourceInfo;
    }
}
