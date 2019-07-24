package com.zryx.company.service;

import com.zryx.company.common.config.PageConfig;
import com.zryx.company.model.Message;

import java.util.List;

/**
 * 针对信息进行的业务处理
 */
public interface MessageService {

    /**
     * 查询所有的信息
     * @return
     */
    List<Message> getAllMessages();

    /**
     * 添加信息
     */
    void addMessage(Message message);

    /**
     * 删除信息
     */
    void delMessage(int messageId);

    /**
     * 修改信息
     */
    void updMessage(Message message);

    /**
     *根据消息Id查询消息
     * @param id
     * @return
     */
    Message getMessageById(int id);

    /**
     * 得到当前页的页面信息
     * @param page
     * @return
     */
    PageConfig<Message> getMessageByPage(int page);

}
