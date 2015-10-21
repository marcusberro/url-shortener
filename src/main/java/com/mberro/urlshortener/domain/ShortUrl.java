package com.mberro.urlshortener.domain;

import java.time.LocalDateTime;

/**
 * Created by Marcus Berro on 21/10/15.
 */
//@Entity
//@Table(name="short_url", uniqueConstraints={@UniqueConstraint(columnNames={"code"})})
public class ShortUrl {


//    @Id
//    @GeneratedValue
//    @Column(name="id")
    private Long id;

//    @Column(name="code")
    private String code;

//    @Column(name="url")
    private String url;

//    @Column(name="creationDate")
//    @Type(type="org.joda.time.contrib.hibernate.PersistentLocalDateTime")
    private LocalDateTime creationDate;

//    @Column(name="hits")
    private Long hits;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public Long getHits() {
        return hits;
    }

    public void setHits(Long hits) {
        this.hits = hits;
    }

    public void increaseHits(){
        this.hits += 1;
    }

    @Override
    public String toString() {
        return "ShortUrl{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", url='" + url + '\'' +
                ", creationDate=" + creationDate +
                ", hits=" + hits +
                '}';
    }
}