package com.mberro.urlshortener.domain;

import com.mberro.urlshortener.domain.repository.ShortenerRepository;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by Marcus Berro on 21/10/15.
 */
@Entity
@Table(name="shorten_url", uniqueConstraints={@UniqueConstraint(columnNames={"code"})})
public class ShortenUrl {

    @Id
    @GeneratedValue
    @Column(name="id")
    private Long id;

    @Column(name="code")
    private String code;

    @Column(name="url")
    private String url;

    @Column(name="creationDate")
    private LocalDateTime creationDate;

    @Column(name="hits")
    private Long hits;

    public ShortenUrl() {
    }

    public ShortenUrl(String url) {
        setUrl(url);
        setHits(0l);
        setCreationDate(LocalDateTime.now());
    }

    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getUrl() {
        return url;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public Long getHits() {
        return hits;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCode(String code) {
        this.code = code;
    }

    private void setUrl(String url) {
        // TODO Validate URL
        this.url = url;
    }

    private void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    private void setHits(Long hits) {
        this.hits = hits;
    }

    // TODO autowire those services?
    public void shorten(CodeService codeService, ShortenerRepository shortenerRepository) {
        shortenerRepository.save(this);
        setCode(codeService.nextCode(getId()));
    }

    // TODO check for concurrency
    public void increaseHits(){
        this.hits += 1;
    }

    @Override
    public String toString() {
        return "ShortenUrl{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", url='" + url + '\'' +
                ", creationDate=" + creationDate +
                ", hits=" + hits +
                '}';
    }
}