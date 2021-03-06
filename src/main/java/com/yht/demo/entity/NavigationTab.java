package com.yht.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.util.Date;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * app首页导航选项卡
 * </p>
 *
 * @author generator
 * @since 2019-04-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_navigation_tab")
public class NavigationTab extends Model<NavigationTab> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 客户端Id
     */
    private Integer clientId;

    /**
     * 是否有效（0:无效，1:有效）
     */
    private Integer isValid;

    /**
     * 导航栏索引
     */
    private Integer navigatorIndex;

    /**
     * 导航栏名称
     */
    private String navigatorName;

    /**
     * 导航栏标签名
     */
    private String navigatorTagName;

    /**
     * 导航栏标签颜色
     */
    private String navigatorTagColor;

    /**
     * 导航栏标签
     */
    private String navigatorIcon;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 是否删除（0:未删除  1:已删除）
     */
    private Integer delFlag;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
