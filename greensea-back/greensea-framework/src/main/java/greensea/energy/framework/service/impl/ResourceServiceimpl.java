package greensea.energy.framework.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import greensea.energy.common.domain.R;
import greensea.energy.common.utils.DateUtils;
import greensea.energy.common.utils.RandomUtils;
import greensea.energy.framework.domain.entity.ResourceEntity;
import greensea.energy.framework.domain.vo.ResourceVo;
import greensea.energy.framework.mapper.ResourceMapper;
import greensea.energy.framework.service.IResourceService;
import greensea.energy.framework.web.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;

/**
 * @ClassName: ResourceServiceimpl
 * @Description:
 * @Author: gmslymhn
 * @CreateTime: 2024-05-22 03:23
 * @Version: 1.0
 **/
@Service
public class ResourceServiceimpl implements IResourceService {
    @Autowired
    private ResourceMapper resourceMapper;

    public R addResource(MultipartFile file,Integer type){
        String fileName = file.getOriginalFilename();
        //获取文件后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        String imagePath = null;
        if(type == 3 && suffixName.equals(".md")){
            imagePath ="Markdown\\";
        }else if(type==1 && (suffixName.equals(".jpg") || suffixName.equals(".png"))){
            imagePath ="Image\\";
        }else if(type==2 && suffixName.equals(".mp4")){
            imagePath ="Video\\";
        }else {
            return R.error("文件格式错误！");
        }
        //重新生成文件名
        Date date = new Date();
        String fileName1 = DateUtils.format(date)+ RandomUtils.createCode(4);
        String fileName2 = fileName1 + suffixName;

        try {
            BufferedOutputStream out = new BufferedOutputStream(
                    new FileOutputStream(new File("selab-resources\\"+imagePath + fileName2)));
            out.write(file.getBytes());
            out.flush();
            out.close();
            ResourceEntity resourceEntity = new ResourceEntity();
            resourceEntity.setResourcePath(imagePath + fileName2);
            resourceEntity.setResourceName(fileName1);
            resourceEntity.setResourceType(type);
            resourceEntity.setCreateUser(SecurityUtils.getUserAccount());
            resourceEntity.setResourceState(false);
            resourceMapper.insert(resourceEntity);
            QueryWrapper<ResourceEntity> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("resource_path", resourceEntity.getResourcePath());
            ResourceEntity resourceEntity1 =resourceMapper.selectOne(queryWrapper);
            ResourceVo resourceVo = new ResourceVo();
            resourceVo.setResourceId(resourceEntity1.getResourceId());
            resourceVo.setResourceName(fileName1);
            resourceVo.setResourceType(type);
            return R.success(resourceVo);
        } catch (Exception e) {
            e.printStackTrace();
            return R.error("文件添加失败！");
        }
    }

}
