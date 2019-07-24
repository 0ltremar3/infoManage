package com.zryx.company.mapper;

import com.zryx.company.model.Revert;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RevertMapper {

    /**
     *根据messageId查询回复，以时间倒序排序
     * @return回复列表
     */
    List<Revert> getRevertByMesId(@Param("messageId") int messageId);

    /**
     * 创建回复
     * @param revert
     * @return 返回值>0则为添加成功
     */
    int addRevert(Revert revert);//是否可以用布尔值替代？

    /**
     * 根据userId删除回复.管理员能删掉所有回复，用户只能删掉自己的回复
     */
//    int delRevert(@Param("userId") int userId);
}
