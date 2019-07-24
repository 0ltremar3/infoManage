package com.zryx.company.mapper;

import com.zryx.company.model.Message;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MessageMapperTest {

    @Autowired
    private MessageMapper messageMapper;

    @Test
    public void getAllMessageTest(){
        List<Message> messages = messageMapper.getAllMessage();
        for (Message m : messages){
            System.out.println(m);
        }
    }

    @Test
    public void addMessageTest(){
        Message message = new Message(0,"why",
                "I don't know", "oltremare",new Date(),4);
        int row = messageMapper.addMessage(message);
        if (row > 0){
            System.out.println("添加成功！");
        }
    }

    @Test
    public void delMessageTest(){
        int messageId = 3;
        int row = messageMapper.delMessage(messageId);
        if (row > 0){
            System.out.println("删除成功！");
        }
    }

    @Test
    public void updateMessageTest(){
        Message message = new Message(5,"goodbye","world",
                "oltremare",new Date(), 3);
        int row = messageMapper.updateMessage(message);
        if (row > 0){
            System.out.println("修改成功！");
        }
    }
}
