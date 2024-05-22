package greensea.energy.framework.domain.vo;

import greensea.energy.framework.domain.entity.GmEntity;
import greensea.energy.framework.domain.entity.GmMsgEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

/**
 * @ClassName: MsgVo
 * @Description:
 * @Author: gmslymhn
 * @CreateTime: 2024-05-22 23:36
 * @Version: 1.0
 **/
@Data
@NoArgsConstructor
@Schema(description = "个人信息")
public class MsgVo {
    private String account;
    private String nickname;
    private String avatarUrl;
    private String email;
    private String phone;
    /**
     * 最后登陆ip
     */
    private String lastLoginIp;
    private String lastLoginLocation;
    /**
     * 用户最后一次登陆时间
     */
    private LocalDateTime lastLoginTime;
    /**
     * 角色
     */
    private String role;

}
