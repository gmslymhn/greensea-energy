package greensea.energy.framework.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import greensea.energy.common.domain.R;
import greensea.energy.common.utils.ObjectUtils;
import greensea.energy.common.utils.http.ServletUtils;
import greensea.energy.framework.domain.dto.AddUserDto;
import greensea.energy.framework.domain.dto.UserLoginDto;
import greensea.energy.framework.domain.entity.UserEntity;
import greensea.energy.framework.domain.entity.UserGmEntity;
import greensea.energy.framework.domain.entity.UserMsgEntity;
import greensea.energy.framework.domain.model.LoginUser;
import greensea.energy.framework.domain.model.LoginUserToken;
import greensea.energy.framework.jwt.security.AuthenticationContextHolder;
import greensea.energy.framework.mapper.UserGmMapper;
import greensea.energy.framework.mapper.UserMapper;
import greensea.energy.framework.mapper.UserMsgMapper;
import greensea.energy.framework.service.IUserService;
import greensea.energy.framework.web.SecurityUtils;
import greensea.energy.framework.web.service.LoginService;
import greensea.energy.framework.web.service.TokenService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: UserServiceimpl
 * @Description:
 * @Author: gmslymhn
 * @CreateTime: 2024-05-19 17:40
 * @Version: 1.0
 **/
@Service
public class UserServiceimpl implements IUserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserMsgMapper userMsgMapper;
    @Autowired
    private UserGmMapper userGmMapper;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private LoginService loginService;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public R loginUser(UserLoginDto userLoginDto){
        Authentication authentication = null;
        try{
//            // 创建一个认证令牌，包含用户名和密码
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userLoginDto.getUserAccount(), userLoginDto.getUserPassword());
//            // 调用 AuthenticationManager 进行身份验证
            AuthenticationContextHolder.setContext(authenticationToken);
//            // 该方法会去调用UserDetailsServiceImpl.loadUserByUsername
            authentication = authenticationManager.authenticate(authenticationToken);
        } catch (BadCredentialsException e) {
            return loginService.addLoginFailFrequency(userLoginDto.getUserAccount());
        }
        // 如果身份验证成功，可以从认证对象中获取用户详细信息
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        if (loginUser.getUserType().equals("B")){
            String token = tokenService.createToken(loginUser);
            Map<String, String> map = new HashMap<>();
            map.put("token", token);
            return R.success(map);
        }
        return R.error("账号异常！");
    }

    @Override
    public R addUser(AddUserDto addUserDto){
        QueryWrapper<UserGmEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("account", addUserDto.getUserAccount());
        UserGmEntity userGmEntity = userGmMapper.selectOne(queryWrapper);
        QueryWrapper<UserGmEntity> queryWrapper1 = new QueryWrapper<>();
        queryWrapper1.eq("email", addUserDto.getUserEmail());
        UserGmEntity userGmEntity1 = userGmMapper.selectOne(queryWrapper1);
        if (ObjectUtils.isNotNull(userGmEntity)) {
            return R.error("账号已注册！");
        }
        if(ObjectUtils.isNotNull(userGmEntity1)){
            return R.error("邮箱已注册！");
        }
        userGmEntity = get1(addUserDto);
        userGmMapper.insert(userGmEntity);
        UserGmEntity userGmEntity2 = userGmMapper.selectOne(queryWrapper);
        UserEntity userEntity = get2(addUserDto,userGmEntity2);
        userMapper.insert(userEntity);
        UserMsgEntity userMsgEntity =get3(addUserDto,userGmEntity2);
        userMsgMapper.insert(userMsgEntity);
        return R.success("注册成功！");
    }
    @Override
    public R verifyRegister(String userAccoount, String userEmail){
        QueryWrapper<UserGmEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("email", userEmail);
        UserGmEntity userGmEntity = userGmMapper.selectOne(queryWrapper);
        if (ObjectUtils.isNotNull(userGmEntity)){
            return R.error("该邮箱已注册！");
        }
        QueryWrapper<UserGmEntity> queryWrapper1 = new QueryWrapper<>();
        queryWrapper1.eq("account", userAccoount);
        UserGmEntity userGmEntity1 = userGmMapper.selectOne(queryWrapper1);
        if (ObjectUtils.isNotNull(userGmEntity1)){
            return R.error("该账号已注册！");
        }
        return loginService.addRegisterVerify(userAccoount,userEmail);

    }
    @Override
    public R logoutUser(){
        HttpServletRequest request = ServletUtils.getRequest();
        LoginUserToken loginUserToken =  tokenService.getLoginUserToken(request);
        tokenService.deleteToken(loginUserToken);
        return R.success("退出成功！");
    }
    private UserGmEntity get1(AddUserDto addUserDto){
        UserGmEntity userGmEntity = new UserGmEntity();
        userGmEntity.setAccount(addUserDto.getUserAccount());
        userGmEntity.setEmail(addUserDto.getUserEmail());
        userGmEntity.setType("B");
        userGmEntity.setState(true);
        userGmEntity.setDelFlag(0);
        return userGmEntity;
    }
    private UserEntity get2(AddUserDto addUserDto,UserGmEntity userGmEntity){
        UserEntity userEntity = new UserEntity();
        userEntity.setUserId(userGmEntity.getId());
        userEntity.setUserAccount(addUserDto.getUserAccount());
        userEntity.setUserNickname(addUserDto.getUserNickname());
        userEntity.setUserType("3");
        userEntity.setUserState(true);
        userEntity.setDelFlag(0);
        userEntity.setUserPassword(SecurityUtils.encryptPassword(addUserDto.getUserPassword()));
        return userEntity;
    }
    private UserMsgEntity get3(AddUserDto addUserDto,UserGmEntity userGmEntity){
        UserMsgEntity userMsgEntity = new UserMsgEntity();
        userMsgEntity.setUserId(userGmEntity.getId());
//        userMsgEntity.setUserEmail(addUserDto.getUserEmail());
        userMsgEntity.setDelFlag(0);
        userMsgEntity.setUserPhone(addUserDto.getUserPhone());
        return userMsgEntity;
    }
}
