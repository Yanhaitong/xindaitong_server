package com.yht.demo.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yht.demo.common.BaseServiceImpl;
import com.yht.demo.common.MsgConstant;
import com.yht.demo.common.RedisUtils;
import com.yht.demo.common.Result;
import com.yht.demo.entity.dto.ParameterOrderDetailsDTO;
import com.yht.demo.entity.dto.ParameterOrderListDTO;
import com.yht.demo.entity.dto.ResultOrderDetailsDTO;
import com.yht.demo.entity.model.Order;
import com.yht.demo.entity.model.OrderAllocation;
import com.yht.demo.mapper.OrderAllocationMapper;
import com.yht.demo.mapper.OrderMapper;
import com.yht.demo.mapper.SearchConditionsMapper;
import com.yht.demo.mapper.UserMapper;
import com.yht.demo.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 订单表 服务实现类
 * </p>
 *
 * @author yanht
 * @since 2019-04-19
 */
@Service
public class OrderServiceImpl extends BaseServiceImpl implements IOrderService {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private OrderAllocationMapper orderAllocationMapper;

    @Override
    public Result getHomePageOrderList(ParameterOrderListDTO parameterOrderListDTO) {
        Page page = new Page();
        page.setSize(parameterOrderListDTO.getPageSize());
        page.setCurrent(parameterOrderListDTO.getPageNum());
        IPage<ResultOrderDetailsDTO> resultOrderDetailsDTOIPage = orderMapper.selectOrderListByMap(page, parameterOrderListDTO);
        return Result.success(resultOrderDetailsDTOIPage);
    }

    @Override
    public Result getOrderDetailsById(ParameterOrderDetailsDTO parameterOrderDetailsDTO) {
        Integer myOrderInt = 0;
        //查询此订单是否是当前用户已抢订单
        Order order = orderMapper.selectById(parameterOrderDetailsDTO.getOrderId());
        if (!StringUtils.isEmpty(order.getStatus()) && order.getStatus() != 0){
            String userId = RedisUtils.getUserIdByToken(parameterOrderDetailsDTO.getToken());
            if (StringUtils.isEmpty(userId)){
                return Result.error(500, MsgConstant.USER_ID_IS_NULL);
            }
            Map<String, Object> parameterMap = new HashMap<>();
            parameterMap.put("orderId", order.getId());
            parameterMap.put("userId", userId);
            List<OrderAllocation> orderAllocationList = orderAllocationMapper.selectByMap(parameterMap);
            if (orderAllocationList.size() >= 1){//此订单是当前用户已抢订单
                myOrderInt = 1;
            }
        }

        ResultOrderDetailsDTO resultOrderDetailsDTO = orderMapper.getOrderDetailsById(parameterOrderDetailsDTO.getOrderId(), myOrderInt);
        return Result.success(resultOrderDetailsDTO);
    }

}
