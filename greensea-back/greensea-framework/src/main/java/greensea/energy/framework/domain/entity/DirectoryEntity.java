package greensea.energy.framework.domain.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: DirectoryEntity
 * @Description:
 * @Author: gmslymhn
 * @CreateTime: 2024-05-21 14:21
 * @Version: 1.0
 **/
@TableName("gre_directory")
@Data
@Schema(description = "目录实体类")
@NoArgsConstructor
public class DirectoryEntity {

    /**
     * 目录id
     */
    @TableId(value = "directory_id",type = IdType.AUTO)
    private Integer directoryId;
    /**
     * 目录icon
     */
    @TableField("directory_icon")
    @NotBlank(message = "目录icon不能为空")
    @Size(min = 1, max = 30, message = "目录icon必须在1~30字符之间")
    private String directoryIcon;
    /**
     * 目录path
     */
    @TableField("directory_path")
    @NotBlank(message = "目录path不能为空")
    @Size(min = 1, max = 30, message = "目录pyth必须在1~30字符之间")
    private String directoryPath;
    /**
     * 目录姓名
     */
    @NotBlank(message = "目录姓名不能为空")
    @TableField("directory_name")
    @Size(min = 1, max = 30, message = "目录姓名必须在1~30字符之间")
    private String directoryName;
    /**
     * 目录标题
     */
    @NotBlank(message = "目录标题不能为空")
    @TableField("directory_title")
    @Size(min = 1, max = 30, message = "目录标题必须在1~30字符之间")
    private String directoryTitle;
    /**
     * 重定向
     */
    @TableField("directory_redirect")
    @Size(min = 1, max = 30)
    private String directoryRedirect;
    /**
     * 目录等级
     */
    @TableField("directory_grade")
    @NotBlank(message = "目录等级不能为空")
    private Integer directoryGrade;
    /**
     * 目录上级
     */
    @TableField("directory_superior")
    private Integer directorySuperior;
    /**
     * 目录组件
     */
    @TableField("directory_component")
    @NotBlank(message = "目录组件不能为空")
    @Size(min = 1, max = 50, message = "目录组件必须在1~50字符之间")
    private String directoryComponent;

    /**
     * 目录次序
     */
    @TableField("directory_order")
    private Integer directoryOrder;

    /**
     * 目录类型
     */
    @TableField("directory_type")
    private Integer directoryType;
    /**
     * 目录状态（1正常 0停用）
     */
    @TableField("directory_state")
    private Boolean directoryState;
    /**
     * 逻辑删除(1删除 0未删除)
     */
    @TableLogic
    @TableField("del_flag")
    private Integer delFlag;

}
