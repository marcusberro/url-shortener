package com.mberro.urlshortener.application.representation;

import java.time.LocalDateTime;

/**
 * Created by Marcus Berro on 24/10/15.
 */
public class ShortenResponse {

    private Long urlId;

    private String urlCode;

    private LocalDateTime createdAt;

    private Boolean status;

    private String description;

    public ShortenResponse(Long urlId, String urlCode, LocalDateTime createdAt, Boolean status, String description) {
        setUrlId(urlId);
        setUrlCode(urlCode);
        setCreatedAt(createdAt);
        setStatus(status);
        setDescription(description);
    }

    public Long getUrlId() {
        return urlId;
    }

    public String getUrlCode() {
        return urlCode;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Boolean getStatus() {
        return status;
    }

    public String getDescription() {
        return description;
    }

    private void setUrlId(Long urlId) {
        this.urlId = urlId;
    }

    private void setUrlCode(String urlCode) {
        this.urlCode = urlCode;
    }

    private void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    private void setStatus(Boolean status) {
        this.status = status;
    }

    private void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ShortenResponse{" +
                "urlId=" + urlId +
                ", urlCode='" + urlCode + '\'' +
                ", createdAt=" + createdAt +
                ", status=" + status +
                ", description='" + description + '\'' +
                '}';
    }
}