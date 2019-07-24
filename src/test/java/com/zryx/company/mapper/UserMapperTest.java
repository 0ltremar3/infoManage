package com.zryx.company.mapper;

import com.zryx.company.model.Revert;
import com.zryx.company.model.Users;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Autowired
    UsersMapper usersMapper;

    @Test
    public void findUser(){
        Users user = usersMapper.findUser("admin","admin");
        if (user != null){
            System.out.println(user);
        }
    }
}
