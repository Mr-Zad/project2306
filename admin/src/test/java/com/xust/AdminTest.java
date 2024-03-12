package com.xust;

import com.xust.entity.UmsAdmin;
import com.xust.service.UmsAdminService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminTest {

    @Autowired
    UmsAdminService umsAdminService;


    @Test
    public void testAddAdmin(){

        List<UmsAdmin> list = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            list.add(
                    //String name, String phone, String email, Integer gender, String password,String icon
                    new UmsAdmin(
                        "zs"+i,"123"+i,i+"@qq.com", 0,"123+i","aaa"
                    )
            );
        }

        umsAdminService.saveBatch(list);
    }


}
