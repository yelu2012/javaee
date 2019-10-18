package com.uws.yl.service;

import com.uws.yl.model.RedPacket;

public interface RedPacketService {

    /**
     　* 获取红包信息
     　*/
    RedPacket getRedPacket(Long id);

    /**
     　* 扣减红包记录数
     　*/
    int decreaseRedPacket(Long id);
}
