package com.uws.yl.service;

import com.uws.yl.model.UserRedPacket;

public interface UserRedPacketService {

    /**
     　* 插入抢红包信息
     　*/
    int grabRedPacket(UserRedPacket userRedPacket);

    int grabRedPacketForVersion(UserRedPacket userRedPacket);
}
