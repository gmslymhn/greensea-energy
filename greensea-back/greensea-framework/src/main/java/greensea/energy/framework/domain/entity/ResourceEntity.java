package greensea.energy.framework.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import greensea.energy.common.domain.BaseEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: ResourceEntity
 * @Description:
 * @Author: gmslymhn
 * @CreateTime: 2024-05-22 02:52
 * @Version: 1.0
 **/
@TableName("gre_resource")
@Data
@NoArgsConstructor
public class ResourceEntity extends BaseEntity {
    /**
     * 静态资源id
     */
    @TableId(value = "resource_id" ,type = IdType.AUTO)
    private Integer resourceId;
    /**
     * 资源名称
     */
    @TableField("resource_name")
    private String resourceName;
    /**
     * 资源描述
     */
    @TableField("resource_description")
    private String resourceDescription;
    /**
     * 资源路径
     */
    @TableField("resource_path")
    private String resourcePath;
    /**
     * 资源类型 (0文本 1图片 2视频)
     */
    @TableField("resource_type")
    private Integer resourceType;
    /**
     * 资源链接
     */
    @TableField("resource_url")
    private String resourceUrl;
    /**
     * 资源状态 1停用 0未停用
     */
    @TableField("resource_state")
    private Boolean resourceState;
}
