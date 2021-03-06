package com.github.weijj0528.example.mybatis.dto;

import com.wei.starter.base.valid.Add;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * @author
 * @createTime 2020-09-18 18:02:56
 * @description
 */
@Data
public class UserAuthPhoneDto implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @NotNull(groups = Add.class, message = "ID不能为空")
    private Long id;

    /**
     * 租户ID
     */
    @NotNull(groups = Add.class, message = "租户ID不能为空")
    private Long tenantId;

    /**
     * 电话
     */
    @NotNull(groups = Add.class, message = "电话不能为空")
    private String phone;

    /**
     * 密码
     */
    @NotNull(groups = Add.class, message = "密码不能为空")
    private String pwd;

    /**
     * 用户ID
     */
    @NotNull(groups = Add.class, message = "用户ID不能为空")
    private Long userId;

    /**
     * 是否删除
     */
    @NotNull(groups = Add.class, message = "是否删除不能为空")
    private Boolean del;

    /**
     * 更新人
     */
    @NotNull(groups = Add.class, message = "更新人不能为空")
    private String updater;

    /**
     * 最后更新时间
     */
    @NotNull(groups = Add.class, message = "最后更新时间不能为空")
    private Date utime;

    /**
     * 创建人
     */
    @NotNull(groups = Add.class, message = "创建人不能为空")
    private String creater;

    /**
     * 记录时间
     */
    @NotNull(groups = Add.class, message = "记录时间不能为空")
    private Date ctime;

}
