package com.zryx.company.controller;

import com.zryx.company.common.config.PageConfig;
import com.zryx.company.common.web.BaseController;
import com.zryx.company.mapper.MessageMapper;
import com.zryx.company.model.Message;
import com.zryx.company.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MessageController extends BaseController {

    @Autowired
    MessageService messageService;

    /**
     * 后台控制器当中的一个方法，该方法用来进行查询并返回一个json
     * @PostMapping()用来处理post请求,里面的key不可少
     * @return 向客户端返回json格式的字符串
     */
    @PostMapping("/initMessage")
    //RequestParam作用是请求参数，默认1.required意思是非必须。为啥用这个？
    public String initMessage(@RequestParam(value = "page",required = false,defaultValue = "1") int page){
//        List<Message> messages = messageService.getAllMessages();
        //得到当前分页所有信息
        PageConfig pageConfig = messageService.getMessageByPage(page);
        String json = dealQueryResult(pageConfig,pageConfig);
        logger.debug("Json-->" + json);
        return json;
    }

    /**
     * 添加一条message。调用service中的addMessage方法
     * @param message
     * @return 返回处理成功信息
     */
    @PostMapping("/addMessage")
    public String addMessage(Message message){
        messageService.addMessage(message);
        return dealSuccessResutl("添加成功!",null);
    }

    /**
     * 删除message
     */
    @PostMapping("/delMessage")
    public String delMessage(int messageId){
        messageService.delMessage(messageId);
        return dealSuccessResutl("删除成功！",null);
    }

    /**
     * 修改message
     * @param message
     * @return
     */
    @PostMapping("/updMessage")
    public String updMessage(Message message){
        messageService.updMessage(message);
        return dealSuccessResutl("修改成功!",null);
    }

    @PostMapping("/getMessageById")
    public String getMessageById(int messageId){
        Message message = messageService.getMessageById(messageId);
        String json = dealQueryResult(message,message);
        logger.debug("Json-->" + json);
        return json;
    }

}
