package com.uws.yl.mapper;

import com.uws.yl.model.RedPacket;
import org.springframework.stereotype.Repository;

@Repository
public interface RedPacketMapper {

    /**
    　* 获取红包信息
    　*/
    RedPacket getRedPacket(Long id);

    /**
    　* 悲观锁解决超发问题
    　*/
    RedPacket getRedPacketForUpdate(Long id);

    /**
    　* 扣减红包记录数
    　*/
    int decreaseRedPacket(Long id);

    /**
    　* 乐观锁 解决超发问题
    　*/
    int decreaseRedPacketForVersion(Long id,Long version);
}
