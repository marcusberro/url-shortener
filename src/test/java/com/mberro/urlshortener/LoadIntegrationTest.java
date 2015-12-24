package com.mberro.urlshortener;

import com.mberro.urlshortener.application.ShortenerApplicationService;
import com.mberro.urlshortener.application.representation.ShortenResponse;
import com.mberro.urlshortener.domain.exception.ShortenerException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.StopWatch;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Marcus Berro on 03/11/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {ShortenerApplication.class})
public class LoadIntegrationTest {

    private static Logger log = LoggerFactory.getLogger(LoadIntegrationTest.class);

    private final List<String> sites = Arrays.asList(
            "http://heeeeeeeey.com/",
            "http://thatsthefinger.com/",
            "http://cant-not-tweet-this.com/",
            "http://eelslap.com/",
            "http://www.staggeringbeauty.com/",
            "http://burymewithmymoney.com/",
            "http://www.fallingfalling.com/",
            "http://ducksarethebest.com/",
            "http://www.trypap.com/",
            "http://www.republiquedesmangues.fr/",
            "http://www.movenowthinklater.com/",
            "http://www.partridgegetslucky.com/",
            "http://www.rrrgggbbb.com/",
            "http://beesbeesbees.com/",
            "http://www.sanger.dk/",
            "http://www.koalastothemax.com/",
            "http://www.everydayim.com/",
            "http://www.leduchamp.com/",
            "http://grandpanoclothes.com/",
            "http://www.haneke.net/",
            "http://r33b.net/",
            "http://randomcolour.com/",
            "http://cat-bounce.com/",
            "http://www.sadforjapan.com/",
            "http://www.taghua.com/",
            "http://chrismckenzie.com/",
            "http://hasthelargehadroncolliderdestroyedtheworldyet.com/",
            "http://ninjaflex.com/",
            "http://iloveyoulikeafatladylovesapples.com/",
            "http://ihasabucket.com/",
            "http://corndogoncorndog.com/",
            "http://giantbatfarts.com/",
            "http://www.ringingtelephone.com/",
            "http://www.pointerpointer.com/",
            "http://www.pleasedonate.biz/",
            "http://imaninja.com/",
            "http://willthefuturebeaweso.me/",
            "http://salmonofcapistrano.com/",
            "http://www.ismycomputeron.com/",
            "http://www.wwwdotcom.com/",
            "http://www.nullingthevoid.com/",
            "http://www.muchbetterthanthis.com/",
            "http://www.ouaismaisbon.ch/",
            "http://iamawesome.com/",
            "http://www.pleaselike.com/",
            "http://crouton.net/",
            "http://corgiorgy.com/",
            "http://www.electricboogiewoogie.com/",
            "http://www.nelson-haha.com/",
            "http://www.wutdafuk.com/",
            "http://unicodesnowmanforyou.com/",
            "http://tencents.info/",
            "http://intotime.com/",
            "http://leekspin.com/",
            "http://minecraftstal.com/",
            "http://www.riddlydiddly.com/",
            "http://www.patience-is-a-virtue.org/",
            "http://whitetrash.nl/",
            "http://www.theendofreason.com/",
            "http://zombo.com",
            "http://secretsfornicotine.com/",
            "http://pixelsfighting.com/",
            "http://crapo.la/",
            "http://baconsizzling.com/",
            "http://isitwhite.com/",
            "http://noot.space/",
            "http://tomsdog.com/",
            "http://hardcoreprawnlawn.com/",
            "http://www.omfgdogs.com/",
            "http://thefo.nz/",
            "http://oct82.com/",
            "http://semanticresponsiveillustration.com/");

    @Autowired
    private ShortenerApplicationService shortenerApplicationService;

    private StopWatch stopWatcher;

    @Before
    public void setUp() {
        stopWatcher = new StopWatch("Url Shortener Load test");
    }

    @After
    public void tearDown() {
        log.info(stopWatcher.prettyPrint());
    }

    @Test
    public void test() throws ShortenerException {
        sites.forEach(url -> {
            stopWatcher.start("Shorten url: " + url);
            ShortenResponse shortenUrl = shortenerApplicationService.shorten(url);
            stopWatcher.stop();

            log.info("{}", new Object[]{shortenUrl});

            Assert.assertNotNull(shortenUrl);

            stopWatcher.start("redirect with code [" + shortenUrl.getUrlCode() + "]");
            String urlServ = shortenerApplicationService.getRedirectionUrl(shortenUrl.getUrlCode(), new HashMap<>());
            stopWatcher.stop();

            log.info("{}", new Object[]{urlServ});

            Assert.assertNotNull(urlServ);
            Assert.assertEquals(urlServ, url);
        });
    }
}