package com.yht.demo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value = "抢单接口参数")
@Data
public class ParameterVieForOrderDTO extends ParameterBaseDTO {

    @ApiModelProperty(name = "orderId", value = "订单id", required = true)
    private String orderId;

}
