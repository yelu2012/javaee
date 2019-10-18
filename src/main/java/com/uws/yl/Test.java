package com.uws.yl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

/**
 * @author yelu
 * @ClassName Test
 * @ProjectName other
 * @Description: TODO
 * @date 2018/12/17 0017下午 2:07
 */
public class Test {
    public static void main(String[] args) {
        /*ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/spring/spring-context.xml");
        IRolesService rolesService = applicationContext.getBean(IRolesService.class);
        Roles roles = new Roles();
        roles.setName("yelu");
        int i = rolesService.insertRoles(roles);
        System.out.println(i);*/

        List<Map<String, Integer>> list = new ArrayList<>();
        list.stream().<Consumer<Object>>map(stringObjectMap -> o -> o.toString());


    }


}
