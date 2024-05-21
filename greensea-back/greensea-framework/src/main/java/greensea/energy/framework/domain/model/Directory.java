package greensea.energy.framework.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import greensea.energy.common.utils.ObjectUtils;
import greensea.energy.framework.domain.entity.DirectoryEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName: Directory
 * @Description:
 * @Author: gmslymhn
 * @CreateTime: 2024-05-21 14:35
 * @Version: 1.0
 **/
@Schema(description = "目录信息")
@Data
@NoArgsConstructor
public class Directory {
    /**
     * 上级id
     */
    @JsonIgnore
    private Integer Id;
    /**
     * 目录姓名
     */
    private String name;
    /**
     * 目录路径
     */
    private String path;
    /**
     * 目录组件
     */
    private String component;
    /**
     *重定向
     */
    private String redirect;
    /**
     * mate
     */
    private Meta mate;
    /**
     *  下级
     */
    private List<Directory> children;

    public Directory(DirectoryEntity directoryEntity){
        this.Id = directoryEntity.getDirectoryId();
        this.redirect = directoryEntity.getDirectoryRedirect();
        this.name = directoryEntity.getDirectoryName();
        this.component = directoryEntity.getDirectoryComponent();
        this.path = directoryEntity.getDirectoryPath();
        this.mate = new Meta();
        this.mate.setIcon(directoryEntity.getDirectoryIcon());
        this.mate.setTitle(directoryEntity.getDirectoryTitle());
    }
    public List<Directory> getDirectorys(Integer grade,Integer superId,List<DirectoryEntity> directoryEntityList){
        List<DirectoryEntity> directoryEntityList1 =new ArrayList<>();
        if (ObjectUtils.isNotNull(superId)){
            directoryEntityList1 = directoryEntityList.stream()
                    .filter(directory -> directory.getDirectoryGrade().equals(grade) &&
                            directory.getDirectorySuperior().equals(superId))
                    .collect(Collectors.toList());
        }else {
            directoryEntityList1 = directoryEntityList.stream()
                    .filter(directory -> directory.getDirectoryGrade().equals(grade))
                            .collect(Collectors.toList());
        }//按照List中对象的id属性升序
        directoryEntityList1.sort(Comparator.comparing(DirectoryEntity::getDirectoryGrade, Comparator.nullsLast(Comparator.naturalOrder())).reversed());
        List<Directory> directoryList =  new ArrayList<Directory>();
        for (DirectoryEntity directoryEntity:directoryEntityList1){
            Directory directory  = new Directory(directoryEntity);
            directoryList.add(directory);
        }
        //按照List中对象的id属性升序

        return directoryList;
    }
}
