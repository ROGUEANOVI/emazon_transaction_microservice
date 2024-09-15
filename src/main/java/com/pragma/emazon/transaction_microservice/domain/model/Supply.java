package com.pragma.emazon.transaction_microservice.domain.model;

import java.time.LocalDateTime;

public class Supply {

    private Long id;

    private Long articleId;

    private Integer quantity;

    private String status;

    private Long createdByUserId;

    private LocalDateTime supplyDate;

    public Supply() {

    }

    public Supply(Long id, Long articleId, Integer quantity, String status, Long createdByUserId, LocalDateTime supplyDate) {

        this.id = id;
        this.articleId = articleId;
        this.quantity = quantity;
        this.status = status;
        this.createdByUserId = createdByUserId;
        this.supplyDate = supplyDate;
    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public Long getArticleId() {

        return articleId;
    }

    public void setArticleId(Long articleId) {

        this.articleId = articleId;
    }

    public Integer getQuantity() {

        return quantity;
    }

    public void setQuantity(Integer quantity) {

        this.quantity = quantity;
    }

    public String getStatus() {

        return status;
    }

    public void setStatus(String status) {

        this.status = status;
    }

    public Long getCreatedByUserId() {

        return createdByUserId;
    }

    public void setCreatedByUserId(Long createdByUserId) {

        this.createdByUserId = createdByUserId;
    }

    public LocalDateTime getSupplyDate() {

        return supplyDate;
    }

    public void setSupplyDate(LocalDateTime supplyDate) {

        this.supplyDate = supplyDate;
    }
}
