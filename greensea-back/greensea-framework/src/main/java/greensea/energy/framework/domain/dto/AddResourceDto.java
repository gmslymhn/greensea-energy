package greensea.energy.framework.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * @ClassName: AddResourceDto
 * @Description:
 * @Author: gmslymhn
 * @CreateTime: 2024-05-22 02:58
 * @Version: 1.0
 **/
@Data
@Schema(description = "添加资源类")
public class AddResourceDto {
    /**
     * 资源名称
     */
    @NotBlank(message = "文件名称不能为空")
    @Schema(description = "资源名称")
    @Size(min=1, max=20,message="文件名称必须在 1 ~ 20 字符之间")
    private String resourceName;
    /**
     * 资源描述
     */
    @Schema(description = "资源描述")
    @Size(min=1, max=200,message="资源描述必须在 1 ~ 200 字符之间")
    private String resourceDescription;
    /**
     * 资源类型 (0文本 1图片 2视频)
     */
    @Schema(description = "资源类型 0文字 1图片 2视频 3md文档")
    @NotBlank(message = "资源类型不能为空")
    private Integer resourceType;

}
