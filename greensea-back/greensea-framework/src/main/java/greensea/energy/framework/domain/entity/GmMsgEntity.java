package greensea.energy.framework.domain.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import greensea.energy.common.constant.UserConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * @ClassName: GmMsgEntitiy
 * @Description: 管理员信息
 * @Author: gmslymhn
 * @CreateTime: 2024-05-18 16:03
 * @Version: 1.0
 **/
@TableName("gre_gm_msg")
@Schema(description = "管理员信息")
@Data
public class GmMsgEntity {
    /**
     * 用户id
     */
    @TableId("gm_id")
    private Integer gmId;
    /**
     * 用户姓名
     */
    @NotBlank(message = "姓名不能为空")
    @Size(min = UserConstants.USERNAME_MIN_LENGTH, max = UserConstants.USERNAME_MAX_LENGTH, message = "姓名必须在2~20字符之间")
    @TableField("gm_name")
    private String gmName;
    /**
     * 用户性别
     */
    @TableField("gm_sex")
    private String gmSex;
    /**
     * 用户头像
     */
    @TableField(" gm_avatar")
    private Integer gmAvatar;
    /**
     * 电话
     */
    @TableField("gm_phone")
    @NotBlank(message = "电话不能为空")
    @Size(min=11, max=11,message="电话长度必须在为11位")
    private String gmPhone;
    /**
     * 邮箱
     */
    @TableField("gm_email")
    @Email
    private String gmEmail;
    /**
     * 备注
     */
    @TableField("remark")
    @Size(max = 200, message = "备注最多200字")
    private String remark;

    /**
     * 逻辑删除(1删除 0未删除)
     */
    @TableLogic
    @TableField("del_flag")
    private Integer delFlag;

}
