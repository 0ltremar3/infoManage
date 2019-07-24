package com.zryx.company.service.imp;

import com.zryx.company.common.exception.CustomException;
import com.zryx.company.mapper.RevertMapper;
import com.zryx.company.model.Revert;
import com.zryx.company.service.RevertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RevertServiceImpl implements RevertService {

    @Autowired
    private RevertMapper revertMapper;

    @Override
    public List<Revert> getRevertByMesId(int messageId) {
        List<Revert> revertList = revertMapper.getRevertByMesId(messageId);
        return revertList;
    }

    @Override
    public void addRevert(Revert revert) {
        int row = revertMapper.addRevert(revert);
        if(row == 0) {
            throw new CustomException(100,"回复创建失败");
        }
    }
}
