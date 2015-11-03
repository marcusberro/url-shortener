package com.mberro.urlshortener.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Map;

/**
 * Created by Marcus Berro on 24/10/15.
 */
@Entity
@Table(name="source_info")
public class SourceInfo {

    @Id
    @GeneratedValue
    @Column(name="id")
    private Long id;

    // http://en.wikipedia.org/wiki/WURFL
    // http://en.wikipedia.org/wiki/UAProf
    // http://en.wikipedia.org/wiki/User_agent_string#User_agent_identification
    // http://developers.sun.com/mobility/midp/ttips/HTTPPost/
    @Column(name="userAgent")
    private String userAgent;

    @Column(name="sourceHost")
    private String sourceHost;

    @Column(name="sourceRequestDate")
    private LocalDateTime sourceRequestDate;

    public SourceInfo() {
    }

    public SourceInfo(Map<String, String> requestInfo) {
        setUserAgent(requestInfo.get("userAgent"));
        setSourceHost(requestInfo.get("sourceHost"));
        if (requestInfo.get("sourceRequestDate") != null)
            setSourceRequestDate(LocalDateTime.parse(requestInfo.get("sourceRequestDate")));
    }

    public SourceInfo(String userAgent, String sourceHost, LocalDateTime sourceRequestDate) {
        setUserAgent(userAgent);
        setSourceHost(sourceHost);
        setSourceRequestDate(sourceRequestDate);
    }

    public Long getId() {
        return id;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public String getSourceHost() {
        return sourceHost;
    }

    public LocalDateTime getSourceRequestDate() {
        return sourceRequestDate;
    }

    private void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    private void setSourceHost(String sourceHost) {
        this.sourceHost = sourceHost;
    }

    private void setSourceRequestDate(LocalDateTime sourceRequestDate) {
        this.sourceRequestDate = sourceRequestDate;
    }

    @Override
    public String toString() {
        return "SourceInfo{" +
                "id=" + id +
                ", userAgent='" + userAgent + '\'' +
                ", sourceHost='" + sourceHost + '\'' +
                ", sourceRequestDate=" + sourceRequestDate +
                '}';
    }
}