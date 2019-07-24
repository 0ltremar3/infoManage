package com.zryx.company.mapper;

import com.zryx.company.model.Revert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RevertMapperTest {

    @Autowired
    private RevertMapper revertMapper;

    @Test
    public void getRevertByMesId(){
        int messageId = 1;
        List<Revert> revertList = revertMapper.getRevertByMesId(messageId);
        for (Revert revert : revertList){
            System.out.println(revert);
        }
    }

    @Test
    public void addRevert(){
        Revert revert = new Revert(0,16,"这都说的啥","angel",new Date());
        int row = revertMapper.addRevert(revert);
        if (row > 0){
            System.out.println("添加成功！");
        }
    }
}
