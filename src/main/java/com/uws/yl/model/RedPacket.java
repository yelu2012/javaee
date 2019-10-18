package com.uws.yl.model;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author yelu
 * @ClassName RedPacket
 * @ProjectName other
 * @Description: TODO
 * @date 2018/12/18 0018下午 1:31
 */
public class RedPacket implements Serializable {
    private static final long serialVersionUID = 8949195968022905881L;
    private Long id;

    private Long userId;

    private Double amount;

    private Timestamp sendDate;

    private Integer total;

    private Double unitAmount;

    private Integer stock;

    private Long version;

    private String note;

    public Long getId() {
        return id;
    }

    public RedPacket setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getUserId() {
        return userId;
    }

    public RedPacket setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public Double getAmount() {
        return amount;
    }

    public RedPacket setAmount(Double amount) {
        this.amount = amount;
        return this;
    }

    public Timestamp getSendDate() {
        return sendDate;
    }

    public RedPacket setSendDate(Timestamp sendDate) {
        this.sendDate = sendDate;
        return this;
    }

    public Integer getTotal() {
        return total;
    }

    public RedPacket setTotal(Integer total) {
        this.total = total;
        return this;
    }

    public Double getUnitAmount() {
        return unitAmount;
    }

    public RedPacket setUnitAmount(Double unitAmount) {
        this.unitAmount = unitAmount;
        return this;
    }

    public Integer getStock() {
        return stock;
    }

    public RedPacket setStock(Integer stock) {
        this.stock = stock;
        return this;
    }

    public Long getVersion() {
        return version;
    }

    public RedPacket setVersion(Long version) {
        this.version = version;
        return this;
    }

    public String getNote() {
        return note;
    }

    public RedPacket setNote(String note) {
        this.note = note;
        return this;
    }
}
