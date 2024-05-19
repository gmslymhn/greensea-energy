package greensea.energy.framework.domain.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import greensea.energy.common.constant.UserConstants;
import greensea.energy.common.validator.Xss;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * @ClassName: AddGmDto
 * @Description:
 * @Author: gmslymhn
 * @CreateTime: 2024-05-19 17:54
 * @Version: 1.0
 **/
@Data
@Schema(description = "添加管理员信息")
public class AddGmDto {
    @Schema(description = "账号")
    @Xss(message = "用户账号不能包含脚本字符")
    @NotBlank(message = "账号不能为空")
    @Size(min = 5, max = 20, message = "账号必须在5~20字符之间")
    private String userAccount;

    @Schema(description = "密码")
    @NotBlank(message = "用户密码不能为空")
    @Xss(message = "用户密码不能包含脚本字符")
    @Size(min=6, max=15,message="密码长度必须在 6 ~ 15 字符之间")
    private String userPassword;

    /**
     * 用户昵称
     */
    @NotBlank(message = "昵称不能为空")
    @Schema(description = "用户昵称")
    @Size(min = UserConstants.USERNAME_MIN_LENGTH, max = UserConstants.USERNAME_MAX_LENGTH, message = "昵称必须在2~20字符之间")
    @TableField("user_nickname")
    private String userNickname;
    /**
     * 电话
     */
    @NotBlank(message = "电话不能为空")
    @Size(min=11, max=11,message="电话长度必须在为11位")
    private String gmPhone;
    /**
     * 邮箱
     */
    @Email
    @NotBlank(message = "邮箱不能为空")
    private String userEmail;
}
