package com.uws.yl.service.impl;

import com.uws.yl.mapper.RedPacketMapper;
import com.uws.yl.mapper.UserRedPacketMapper;
import com.uws.yl.model.RedPacket;
import com.uws.yl.model.UserRedPacket;
import com.uws.yl.service.UserRedPacketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author yelu
 * @ClassName UserRedPacketServiceImpl
 * @ProjectName other
 * @Description: TODO
 * @date 2018/12/18 0018下午 2:30
 */
@Service("userRedPacketServiceImpl")
public class UserRedPacketServiceImpl implements UserRedPacketService {

    @Autowired
    private RedPacketMapper redPacketMapper ;
    @Autowired
    private UserRedPacketMapper userRedPacketMapper;

    private static final int FAILED = 0;

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
    public int grabRedPacket(UserRedPacket userRedPacket) {
        //没有使用锁 会产生超发问题
        //RedPacket redPacket = this.redPacketMapper.getRedPacket(userRedPacket.getRedPacketId());
        //使用悲观锁
        RedPacket redPacket = this.redPacketMapper.getRedPacketForUpdate(userRedPacket.getRedPacketId());
        if(redPacket.getStock()>0){
            this.redPacketMapper.decreaseRedPacket(userRedPacket.getRedPacketId());
            userRedPacket.setAmount(redPacket.getUnitAmount()).setNote("抢红包"+userRedPacket.getRedPacketId());
            return this.userRedPacketMapper.grabRedPacket(userRedPacket);
        }
        return FAILED;
    }

    /**
    　* 使用乐观锁 解决超发问题
    　*/
    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
    public int grabRedPacketForVersion(UserRedPacket userRedPacket){
        //记录开始时间
        long start = System.currentTimeMillis();
        while(true){
            long end = System.currentTimeMillis();
            //当超过100毫秒 返回失败
            if(end - start > 100){
                return FAILED;
            }
            //获取红包信息 并获取了version的值
            RedPacket redPacket = this.redPacketMapper.getRedPacket(userRedPacket.getRedPacketId());
            //当前小红包库存大于0 可以扣减
            if(redPacket.getStock()>0){
                int update = this.redPacketMapper.decreaseRedPacketForVersion(redPacket.getId(), redPacket.getVersion());
                // 如果没有更新数据,则说明其他线程已经修改过数据 ，则从新抢夺
                if(update == 0){
                    continue;
                }
                //生成抢红包信息
                userRedPacket.setAmount(redPacket.getUnitAmount()).setNote("抢红包"+userRedPacket.getRedPacketId());
                //插入抢红包信息
                return this.userRedPacketMapper.grabRedPacket(userRedPacket);
            }else{
                return FAILED;
            }
        }
    }
}
