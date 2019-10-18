package com.uws.yl.service.impl;

import com.uws.yl.mapper.RedPacketMapper;
import com.uws.yl.model.RedPacket;
import com.uws.yl.service.RedPacketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author yelu
 * @ClassName RedPacketServiceImpl
 * @ProjectName other
 * @Description: TODO
 * @date 2018/12/18 0018下午 2:30
 */
@Service("redPacketServiceImpl")
public class RedPacketServiceImpl implements RedPacketService {
    @Autowired
    private RedPacketMapper redPacketMapper ;

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
    public RedPacket getRedPacket(Long id) {
        return this.redPacketMapper.getRedPacket(id);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
    public int decreaseRedPacket(Long id) {
        return this.redPacketMapper.decreaseRedPacket(id);
    }
}
