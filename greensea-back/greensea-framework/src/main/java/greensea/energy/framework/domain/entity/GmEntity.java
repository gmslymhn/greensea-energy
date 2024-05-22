package greensea.energy.framework.domain.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import greensea.energy.common.constant.UserConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

/**
 * @ClassName: GmEntity
 * @Description: 管理员实体类
 * @Author: gmslymhn
 * @CreateTime: 2024-05-18 15:25
 * @Version: 1.0
 **/
@TableName("gre_gm")
@Data
@Schema(description = "管理员实体类")
@NoArgsConstructor
public class GmEntity {
    /**
     * 管理员id
     */
    @Schema(description = "管理员id")
    @TableId(value = "gm_id")
    private Integer gmId;
    /**
     * 账号
     */
    @TableField("gm_account")
    @Schema(description = "账号")
    @NotBlank(message = "账号不能为空")
    @Size(min = UserConstants.USERACCOUNT_MIN_LENGTH, max = UserConstants.USERACCOUNT_MAX_LENGTH, message = "账号必须在5~20字符之间")
    private String gmAccount;
    /**
     * 密码
     */
    @TableField("gm_password")
    @Schema(description = "密码")
    @NotBlank(message = "管理员密码不能为空")
    @Size(min=UserConstants.PASSWORD_MIN_LENGTH, max=UserConstants.PASSWORD_MAX_LENGTH,message="密码长度必须在 6 ~ 15 字符之间")
    private String gmPassword;
    /**
     * 管理员姓名
     */
    @NotBlank(message = "昵称不能为空")
    @Schema(description = "管理员昵称")
    @Size(min = UserConstants.USERNAME_MIN_LENGTH, max = UserConstants.USERNAME_MAX_LENGTH, message = "姓名必须在2~20字符之间")
    @TableField("gm_nickname")
    private String gmNickname;

    /**
     * 归属部门
     */
    @TableField("gm_type")
    private String gmType;
    /**
     * 管理员角色
     */
    @TableField(exist = false)
    private Set<String> gmRole;
    /**
     * 登陆次数
     */
    @TableField("login_total")
    private Integer loginTotal;
    /**
     * 最后登陆ip
     */
    @TableField("last_login_ip")
    private String lastLoginIp;
    /**
     * 最后登陆地址
     */
    @TableField("last_login_location")
    private String lastLoginLocation;
    /**
     * 管理员最后一次登陆时间
     */
    @TableField("last_login_time")
    private LocalDateTime lastLoginTime;
    /**
     * 管理员登陆状态
     */
    @TableField("gm_state")
    private Boolean gmState;
    /**
     * 逻辑删除(1删除 0未删除)
     */
    @TableLogic
    @TableField("del_flag")
    private Integer delFlag;
}
