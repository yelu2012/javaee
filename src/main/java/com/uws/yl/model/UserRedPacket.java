package com.uws.yl.model;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author yelu
 * @ClassName UserRedPacket
 * @ProjectName other
 * @Description: TODO
 * @date 2018/12/18 0018下午 1:40
 */
public class UserRedPacket implements Serializable {

    private static final long serialVersionUID = 2049679545691088810L;
    private Long id;

    private Long redPacketId;

    private Long userId;

    private Double amount;

    private Timestamp grabTime;

    private String note;

    public Long getId() {
        return id;
    }

    public UserRedPacket setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getRedPacketId() {
        return redPacketId;
    }

    public UserRedPacket setRedPacketId(Long redPacketId) {
        this.redPacketId = redPacketId;
        return this;
    }

    public Long getUserId() {
        return userId;
    }

    public UserRedPacket setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public Double getAmount() {
        return amount;
    }

    public UserRedPacket setAmount(Double amount) {
        this.amount = amount;
        return this;
    }

    public Timestamp getGrabTime() {
        return grabTime;
    }

    public UserRedPacket setGrabTime(Timestamp grabTime) {
        this.grabTime = grabTime;
        return this;
    }

    public String getNote() {
        return note;
    }

    public UserRedPacket setNote(String note) {
        this.note = note;
        return this;
    }
}
