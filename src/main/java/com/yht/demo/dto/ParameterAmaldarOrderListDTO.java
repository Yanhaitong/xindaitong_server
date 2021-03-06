package com.yht.demo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author yanht
 * @since 2019-04-19
 */
@ApiModel(value = "查询经理订单列表参数")
@Data
public class ParameterAmaldarOrderListDTO extends ParameterBaseDTO {

    @ApiModelProperty(name = "searchContent", value = "输入的搜索内容", required = true)
    private String searchContent;

    @ApiModelProperty(name = "pageSize", value = "每页个数", required = true)
    private Integer pageSize;

    @ApiModelProperty(name = "pageNum", value = "页数", required = true)
    private Integer pageNum;

}