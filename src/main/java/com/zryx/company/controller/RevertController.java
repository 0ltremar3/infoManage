package com.zryx.company.controller;

import com.zryx.company.common.web.BaseController;
import com.zryx.company.model.Revert;
import com.zryx.company.service.RevertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RevertController extends BaseController {

    @Autowired
    RevertService revertService;

    @PostMapping("/initRevert")
    public String initRevert(int messageId){
        List<Revert> reverts = revertService.getRevertByMesId(messageId);
        String json = dealQueryResult(reverts,reverts);
        logger.debug("Json==>" + json);
        return json;
    }

    @PostMapping("/addRevert")
    public String addRevert(Revert revert){
        revertService.addRevert(revert);
        String json = dealSuccessResutl("回复成功！",null);
        logger.debug("Json==>" + json);
        return json;
    }

    // TODO: 2019/7/20 根据messageId创建回复后，对应message count++
}
