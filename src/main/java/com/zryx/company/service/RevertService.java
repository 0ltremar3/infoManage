package com.zryx.company.service;

import com.zryx.company.model.Revert;

import java.util.List;

public interface RevertService {

    /**
     * 根据messageId查询回复，以时间倒序排序
     * @param messageId
     * @return
     */
    List<Revert> getRevertByMesId(int messageId);

    /**
     * 创建回复
     * @param revert
     */
    void addRevert(Revert revert);
}
