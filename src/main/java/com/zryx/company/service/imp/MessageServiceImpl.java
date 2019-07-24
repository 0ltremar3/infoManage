package com.zryx.company.service.imp;

import com.zryx.company.common.config.PageConfig;
import com.zryx.company.common.exception.CustomException;
import com.zryx.company.mapper.MessageMapper;
import com.zryx.company.model.Message;
import com.zryx.company.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageMapper messageMapper;

    @Autowired
    private PageConfig<Message> pageConfig;

    /**
     * 在implement中重写的目的：messageService接口相当于提供了个函数名和参数，大概说明是用来实现什么功能；
     * 而具体的业务逻辑在impl中实现，就需要进行重写。
     * @return
     */
    @Override
    public List<Message> getAllMessages(){
        List<Message> messages = messageMapper.getAllMessage();
        return messages;
    }

    @Override
    public void addMessage(Message message){
        int row = messageMapper.addMessage(message);
        if(row == 0) {
            throw new CustomException(100,"添加信息失败");
        }
    }

    @Override
    public void delMessage(int messageId){
        int row = messageMapper.delMessage(messageId);
        if(row == 0) {
            throw new CustomException(100,"删除信息失败");
        }
    }

    @Override
    public void updMessage(Message message){
        int row = messageMapper.updateMessage(message);
        if(row == 0) {
            throw new CustomException(100,"修改信息失败");
        }
    }

    @Override
    public Message getMessageById(int id) {
        return messageMapper.getMessageById(id);
    }

    /**
     * 分页实现
     * @param page
     * @return
     */
    @Override
    public PageConfig<Message> getMessageByPage(int page) {
        pageConfig.setPageNum(page);
        int pageStart = (pageConfig.pageNum - 1) * pageConfig.pageSize;
        int pageSize = pageConfig.pageSize;
        List<Message> messages = messageMapper.getMessageByPage(pageStart,pageSize);
        pageConfig.setPageData(messages);
        int count = messageMapper.MessageCount();
        System.out.println("pageCount=" + count);
        //别写错成setPageCount了。。。dataCount是总留言条数，pageCount是总页数
        pageConfig.setDataCount(count);
        return pageConfig;
    }
}
