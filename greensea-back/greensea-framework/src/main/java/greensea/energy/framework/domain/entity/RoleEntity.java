package greensea.energy.framework.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import greensea.energy.common.domain.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * @ClassName: RoleEntity
 * @Description:
 * @Author: gmslymhn
 * @CreateTime: 2024-05-19 21:36
 * @Version: 1.0
 **/
@TableName("gre_role")
@Data
public class RoleEntity extends BaseEntity {
    /**
     * 角色id
     */
    @Schema(description = "角色id")
    @TableId(value = "role_id",type = IdType.AUTO)
    private Integer roleId;
    /**
     * 角色名
     */
    @NotBlank(message = "角色名不能为空")
    @Schema(description = "角色名")
    @Size(min = 1, max = 20, message = "角色名必须在1~20字符之间")
    @TableField("role_name")
    private String roleName;
    /**
     * 角色密钥
     */
    @NotBlank(message = "角色密钥不能为空")
    @Schema(description = "角色密钥")
    @TableField("role_key")
    private String rolekey;
    /**
     * 角色类型
     */
    @NotBlank(message = "角色类型不能为空")
    @Schema(description = "角色类型")
    @TableField("role_type")
    private String roleType;
    /**
     * 角色备注
     */
    @Schema(description = "角色备注")
    @TableField("remark")
    @Size(max = 50, message = "备注最多50字")
    private String remark;
}
