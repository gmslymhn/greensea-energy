package greensea.energy.framework.web.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import greensea.energy.common.exception.ServiceException;
import greensea.energy.common.utils.ObjectUtils;
import greensea.energy.framework.domain.entity.GmEntity;
import greensea.energy.framework.domain.entity.RoleEntity;
import greensea.energy.framework.domain.entity.UserEntity;
import greensea.energy.framework.domain.entity.UserGmEntity;
import greensea.energy.framework.domain.model.LoginUser;
import greensea.energy.framework.mapper.GmMapper;
import greensea.energy.framework.mapper.RoleMapper;
import greensea.energy.framework.mapper.UserGmMapper;
import greensea.energy.framework.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @ClassName: AccountUserDetailsService
 * @Description:
 * @Author: gmslymhn
 * @CreateTime: 2024-05-19 18:56
 * @Version: 1.0
 **/
@Service
@Slf4j
public class AccountUserDetailsService implements UserDetailsService {
    @Autowired
    private UserGmMapper userGmMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private GmMapper gmMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Override
    public UserDetails loadUserByUsername(String account) throws UsernameNotFoundException {
        QueryWrapper<UserGmEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("account", account);
        UserGmEntity userGmEntity = userGmMapper.selectOne(queryWrapper);
        if (ObjectUtils.isNull(userGmEntity)){
            log.info("登录用户：{} 不存在.", account);
            throw new ServiceException("对不起，您的账号：" + account + " 不存在");
        }else  if(!userGmEntity.getState()){
            log.info("登录用户：{} 已被停用.", account);
            throw new ServiceException("对不起，您的账号：" + account + " 已停用");
        }
        return createLoginUser(userGmEntity);
    }
    public UserDetails createLoginUser(UserGmEntity userGmEntity) {
        LoginUser loginUser = new LoginUser();
        RoleEntity roleEntity = new RoleEntity();
        if (userGmEntity.getType().equals("A")){
            GmEntity gmEntity = gmMapper.selectById(userGmEntity.getId());
            roleEntity = roleMapper.selectById(Integer.valueOf(gmEntity.getGmType()));
            return new LoginUser(gmEntity.getGmId(),gmEntity.getGmNickname(),null, gmEntity.getGmState(), gmEntity.getGmAccount(),  gmEntity.getGmPassword(), roleEntity.getRolekey(),null);
        }else if (userGmEntity.getType().equals("B")){
            UserEntity userEntity = userMapper.selectById(userGmEntity.getId());
            roleEntity = roleMapper.selectById(userEntity.getUserType());
            return new LoginUser(userEntity.getUserId(),userEntity.getUserNickname(),null, userEntity.getUserState(), userEntity.getUserAccount(),  userEntity.getUserPassword(), roleEntity.getRolekey(),null);
        }
        return null;
    }

}