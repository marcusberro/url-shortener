package com.mberro.urlshortener.domain;

import com.mberro.urlshortener.ShortenerApplication;
import com.mberro.urlshortener.domain.exception.UnknownUrlException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

/**
 * Created by Marcus Berro on 01/11/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {ShortenerApplication.class})
public class ShortenerServiceTest {

    private static Logger log = LoggerFactory.getLogger(ShortenerServiceTest.class);

    @Autowired
    private ShortenerService shortenerService;

    @Test
    public void redirectUrlTest(){
        String url = shortenerService.getRedirectionUrl("aaa", new HashMap<>());
        assertEquals(url, "http://google.com");
    }

    @Test(expected = UnknownUrlException.class)
    public void redirectUnknownUrllTest(){
        shortenerService.getRedirectionUrl("bbb", new HashMap<>());
    }
}
