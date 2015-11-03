package com.mberro.urlshortener.presentation;

import com.mberro.urlshortener.application.ShortenerApplicationService;
import com.mberro.urlshortener.application.representation.ShortenResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created by Marcus Berro on 31/10/15.
 */
@RestController
public class ShortenerController {

    final static Logger log = LoggerFactory.getLogger(ShortenerController.class);

    @Autowired
    private ShortenerApplicationService shortenerApplicationService;

    @RequestMapping(path = "/{code}", method = RequestMethod.GET)
    public void redirect(@PathVariable String code, HttpServletResponse response) throws IOException {
        // TODO colocar header info
        response.sendRedirect(shortenerApplicationService.getRedirectionUrl(code, new HashMap<>()));
    }

    @RequestMapping(path = "/", method = RequestMethod.POST)
    @ResponseBody
    public ShortenResponse shorten(@RequestBody String url, HttpServletRequest request) throws IOException {
        // TODO colocar header info??
        return shortenerApplicationService.shorten(url);
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String helloWorld() {
        return "Home";
    }

}
