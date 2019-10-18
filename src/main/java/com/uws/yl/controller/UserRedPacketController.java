package com.uws.yl.controller;

import com.uws.yl.model.UserRedPacket;
import com.uws.yl.service.UserRedPacketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yelu
 * @ClassName UserRedPacketController
 * @ProjectName other
 * @Description: TODO
 * @date 2018/12/18 0018下午 2:42
 */
@Controller
@RequestMapping("/userRedPacket")
public class UserRedPacketController {

    @Autowired
    private UserRedPacketService userRedPacketService ;

    @RequestMapping("/grabRedPacket")
    public Map<String,Object> grabRedPacket(UserRedPacket userRedPacket){
        int result = this.userRedPacketService.grabRedPacket(userRedPacket);
        boolean flag = result > 0;
        Map<String,Object> map = new HashMap<>();
        map.put("success", flag);
        map.put("message", flag ? "抢红包成功" : "抢红包失败");
        return map;
    }

    @RequestMapping("/grabRedPacketForVersion")
    public Map<String,Object> grabRedPacketForVersion(UserRedPacket userRedPacket){
        int result = this.userRedPacketService.grabRedPacketForVersion(userRedPacket);
        boolean flag = result > 0;
        Map<String,Object> map = new HashMap<>();
        map.put("success", flag);
        map.put("message", flag ? "抢红包成功" : "抢红包失败");
        return map;
    }
}
