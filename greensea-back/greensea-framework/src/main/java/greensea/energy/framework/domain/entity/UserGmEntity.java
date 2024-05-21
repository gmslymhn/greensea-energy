package greensea.energy.framework.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import greensea.energy.common.constant.UserConstants;
import greensea.energy.common.domain.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * @ClassName: UserGmEntity
 * @Description:
 * @Author: gmslymhn
 * @CreateTime: 2024-05-19 19:44
 * @Version: 1.0
 **/
@Data
@TableName("gre_user_gm")
public class UserGmEntity extends BaseEntity {
    /**
     * 管理员id
     */
    @Schema(description = "id")
    @TableId(value = "id",type = IdType.AUTO)
    private Integer Id;
    /**
     * 账号
     */
    @TableField("account")
    @Schema(description = "账号")
    @NotBlank(message = "账号不能为空")
    @Size(min = UserConstants.USERACCOUNT_MIN_LENGTH, max = UserConstants.USERACCOUNT_MAX_LENGTH, message = "账号必须在5~20字符之间")
    private String account;
    /**
     * 邮箱
     */
    @TableField("email")
    @Schema(description = "邮箱")
    @NotBlank(message = "邮箱不能为空")
    @Email(message = "邮箱格式异常")
    private String email;

    /**
     * 类型
     */
    @TableField("type")
    private String type;
    /**
     * 状态
     */
    @TableField("state")
    private Boolean state;
}
