package com.zryx.company.mapper;

import com.zryx.company.model.Message;
import com.zryx.company.model.News;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MessageMapper {

    /**
     * 查message表
     * @return
     */
    List<Message> getAllMessage();

    /**
     * 增加一行数据
     * @param message
     * @return
     */
    int addMessage(Message message);//是否可以用布尔值替代？

    /**
     * 删除一行数据
     * @param messageId
     * @return
     */
    int delMessage(@Param("messageId") int messageId);//删除后messageId不自减?-触发器trigger

    /**
     * 修改某行数据
     * @param message
     * @return
     */
    int updateMessage(Message message);

    /**
     * 根据id查询留言
     * @param id
     * @return
     */
    Message getMessageById(@Param("messageId") int id);

    /**
     * 分页 limit
     * @param pageStart
     * @param pageSize
     * @return
     */
    List<Message> getMessageByPage(@Param("pageStart") int pageStart,@Param("pageSize") int pageSize);

    int MessageCount();
}
