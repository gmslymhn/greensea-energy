package greensea.energy.common.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName: BaseEntity
 * @Description: 基础实体类
 * @Author: gmslymhn
 * @CreateTime: 2024-05-18 10:58
 * @Version: 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 创建用户
     */
    @TableField("create_user")
    private Long createUser;
    /**
     * 创建时间
     */
    @TableField("create_time")
    private String createTime;
    /**
     * 修改用户
     */
    @TableField("update_user")
    private Long updateUser;
    /**
     * 修改时间
     */
    @TableField("update_time")
    private String updateTime;
    /**
     * 逻辑删除(1删除 0未删除)
     */
    @TableLogic
    @TableField("del_flag")
    private boolean delFlag;
}
