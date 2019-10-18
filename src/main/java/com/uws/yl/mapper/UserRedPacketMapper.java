package com.uws.yl.mapper;

import com.uws.yl.model.UserRedPacket;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRedPacketMapper {

    /**
    　* 插入抢红包信息
    　*/
    int grabRedPacket(UserRedPacket userRedPacket);

}
