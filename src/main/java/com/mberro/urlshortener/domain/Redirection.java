package com.mberro.urlshortener.domain;

import java.time.LocalDateTime;

/**
 * Created by Marcus Berro on 21/10/15.
 */
//@Entity
//@Table(name="redirection")
public class Redirection {

//    @Id
//    @GeneratedValue
//    @Column(name="id")
    private Long id;

//    @ManyToOne
//    @JoinColumn(name="shortUrlId")
    private ShortUrl shortUrl;

//    @Column(name="redirectDate")
//    @Type(type="org.joda.time.contrib.hibernate.PersistentLocalDateTime")
    private LocalDateTime redirectDate;

//    @Column(name="sourceRequestDate")
//    @Type(type="org.joda.time.contrib.hibernate.PersistentLocalDateTime")
    private LocalDateTime sourceRequestDate;

    // http://en.wikipedia.org/wiki/WURFL
    // http://en.wikipedia.org/wiki/UAProf
    // http://en.wikipedia.org/wiki/User_agent_string#User_agent_identification
    // http://developers.sun.com/mobility/midp/ttips/HTTPPost/
//    @Column(name="userAgent")
    private String userAgent;

//    @Column(name="sourceHost")
    private String sourceHost;

    @Override
    public String toString() {
        return "Redirection{" +
                "id=" + id +
                ", shortUrl=" + shortUrl +
                ", redirectDate=" + redirectDate +
                ", sourceRequestDate=" + sourceRequestDate +
                ", userAgent='" + userAgent + '\'' +
                ", sourceHost='" + sourceHost + '\'' +
                '}';
    }
}
