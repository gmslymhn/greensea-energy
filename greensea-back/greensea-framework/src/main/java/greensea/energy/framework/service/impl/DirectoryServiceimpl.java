package greensea.energy.framework.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import greensea.energy.common.domain.R;
import greensea.energy.framework.domain.entity.DirectoryEntity;
import greensea.energy.framework.domain.model.Directory;
import greensea.energy.framework.domain.vo.MsgVo;
import greensea.energy.framework.mapper.DirectiryMapper;
import greensea.energy.framework.service.IDirectoryService;
import greensea.energy.framework.web.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: DirectoryServiceimpl
 * @Description:
 * @Author: gmslymhn
 * @CreateTime: 2024-05-21 14:30
 * @Version: 1.0
 **/
@Service
public class DirectoryServiceimpl implements IDirectoryService {
    @Autowired
    private DirectiryMapper directiryMapper;
    @Override
    public R getDirectory(Integer loginType){
        QueryWrapper<DirectoryEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("directory_type", loginType);
        List<DirectoryEntity> directoryEntities = directiryMapper.selectList(queryWrapper);
        List<Directory> directories = new Directory().getDirectorys(1,null,directoryEntities);
        for(Directory directory:directories){
            List<Directory> directories1 = new Directory().getDirectorys(2,directory.getId(),directoryEntities);
            for(Directory directory1:directories1){
                List<Directory> directories2 = new Directory().getDirectorys(3,directory1.getId(),directoryEntities);
                directory1.setChildren(directories2);
            }
            directory.setChildren(directories1);
        }
        return R.success(directories);
    }
}
