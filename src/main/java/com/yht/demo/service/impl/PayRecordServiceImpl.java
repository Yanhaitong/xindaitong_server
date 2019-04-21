package com.yht.demo.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yht.demo.common.BaseServiceImpl;
import com.yht.demo.common.MsgConstant;
import com.yht.demo.common.RedisUtils;
import com.yht.demo.common.Result;
import com.yht.demo.entity.dto.ParameterPayRecordDTO;
import com.yht.demo.entity.dto.ResultPayRecordDTO;
import com.yht.demo.mapper.PayRecordMapper;
import com.yht.demo.service.IPayRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * <p>
 * 充值记录表 服务实现类
 * </p>
 *
 * @author yanht
 * @since 2019-04-20
 */
@Service
public class PayRecordServiceImpl extends BaseServiceImpl implements IPayRecordService {

    @Autowired
    private PayRecordMapper payRecordMapper;

    @Override
    public Result getPayRecordList(ParameterPayRecordDTO parameterPayRecordDTO) {
        String userId = RedisUtils.getUserIdByToken(parameterPayRecordDTO.getToken());
        if (StringUtils.isEmpty(userId)){
            return Result.error(500, MsgConstant.MOBILE_NO_IS_NULL);
        }

        Page page = new Page();
        page.setSize(parameterPayRecordDTO.getPageSize());
        page.setCurrent(parameterPayRecordDTO.getPageNum());
        IPage<ResultPayRecordDTO> resultPayRecordDTOIPage = payRecordMapper.getPayRecordList(page, userId);
        return Result.success(resultPayRecordDTOIPage);
    }
}
