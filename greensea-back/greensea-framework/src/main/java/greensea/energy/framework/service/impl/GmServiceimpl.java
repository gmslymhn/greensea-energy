package greensea.energy.framework.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import greensea.energy.common.domain.R;
import greensea.energy.common.utils.ObjectUtils;
import greensea.energy.common.utils.http.IpUtil;
import greensea.energy.common.utils.http.ServletUtils;
import greensea.energy.framework.domain.dto.AddGmDto;
import greensea.energy.framework.domain.dto.GmLoginDto;
import greensea.energy.framework.domain.entity.*;
import greensea.energy.framework.domain.model.LoginUser;
import greensea.energy.framework.domain.model.LoginUserToken;
import greensea.energy.framework.domain.vo.MsgVo;
import greensea.energy.framework.jwt.security.AuthenticationContextHolder;
import greensea.energy.framework.mapper.GmMapper;
import greensea.energy.framework.mapper.GmMsgMapper;
import greensea.energy.framework.mapper.RoleMapper;
import greensea.energy.framework.mapper.UserGmMapper;
import greensea.energy.framework.service.IGmService;
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

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: GmServiceimpl
 * @Description:
 * @Author: gmslymhn
 * @CreateTime: 2024-05-19 17:38
 * @Version: 1.0
 **/
@Service
public class GmServiceimpl implements IGmService {
    @Autowired
    private GmMapper gmMapper;
    @Autowired
    private GmMsgMapper gmMsgMapper;
    @Autowired
    private LoginService loginService;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private UserGmMapper userGmMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Override
    public R loginGm(GmLoginDto gmLoginDto){
        Authentication authentication = null;
        try{
//            // 创建一个认证令牌，包含用户名和密码
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(gmLoginDto.getGmAccount(), gmLoginDto.getGmPassword());
//            // 调用 AuthenticationManager 进行身份验证
            AuthenticationContextHolder.setContext(authenticationToken);
//            // 该方法会去调用UserDetailsServiceImpl.loadUserByUsername
            authentication = authenticationManager.authenticate(authenticationToken);
        } catch (BadCredentialsException e) {
            return loginService.addLoginFailFrequency(gmLoginDto.getGmAccount());
        }
        // 如果身份验证成功，可以从认证对象中获取用户详细信息
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        if (loginUser.getUserType().equals("A")){
            Map<String, Object> map = getMap(loginUser);
            return R.success(map);
        }
        return R.error("账号异常！");
    }

    private Map<String, Object> getMap(LoginUser loginUser){
        String token = tokenService.createToken(loginUser);
        Map<String, Object> map = new HashMap<>();
        map.put("token", token);
        GmEntity gmEntity = gmMapper.selectById(loginUser.getUserId());
        map.put("lastLoginTime",gmEntity.getLastLoginTime());
        map.put("lastLoginIp",gmEntity.getLastLoginIp());
        map.put("lastLoginLocation",gmEntity.getLastLoginLocation());
        gmEntity.setLoginTotal(gmEntity.getLoginTotal()+1);
        LoginUserToken loginUserToken =tokenService.getLoginUserToken1(token);
        gmEntity.setLastLoginIp(loginUserToken.getIpaddr());
        gmEntity.setLastLoginLocation(loginUserToken.getLoginLocation());
        gmEntity.setLastLoginTime(LocalDateTime.now());
        gmMapper.updateById(gmEntity);
        return map;
    }

    @Override
    public R addGm(AddGmDto addGmDto){
        QueryWrapper<UserGmEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("account", addGmDto.getGmAccount());
        UserGmEntity userGmEntity = userGmMapper.selectOne(queryWrapper);
        QueryWrapper<UserGmEntity> queryWrapper1 = new QueryWrapper<>();
        queryWrapper1.eq("email", addGmDto.getGmEmail());
        UserGmEntity userGmEntity1 = userGmMapper.selectOne(queryWrapper1);
        if (ObjectUtils.isNotNull(userGmEntity)) {
            return R.error("账号已注册！");
        }
        if(ObjectUtils.isNotNull(userGmEntity1)){
            return R.error("邮箱已注册！");
        }
        userGmEntity = get1(addGmDto);
        userGmMapper.insert(userGmEntity);
        UserGmEntity userGmEntity2 = userGmMapper.selectOne(queryWrapper);
        GmEntity gmEntity = get2(addGmDto,userGmEntity2);
        gmMapper.insert(gmEntity);
        GmMsgEntity gmMsgEntity =get3(addGmDto,userGmEntity2);
        gmMsgMapper.insert(gmMsgEntity);
        return R.success("添加成功！");
    }
    private UserGmEntity get1(AddGmDto addGmDto){
        UserGmEntity userGmEntity = new UserGmEntity();
        userGmEntity.setAccount(addGmDto.getGmAccount());
        userGmEntity.setEmail(addGmDto.getGmEmail());
        userGmEntity.setType("A");
        userGmEntity.setState(true);
        userGmEntity.setDelFlag(0);
        return userGmEntity;
    }
    private GmEntity get2(AddGmDto addGmDto, UserGmEntity userGmEntity){
        GmEntity gmEntity = new GmEntity();
        gmEntity.setGmAccount(addGmDto.getGmAccount());
        gmEntity.setGmId(userGmEntity.getId());
        gmEntity.setDelFlag(0);
        gmEntity.setGmState(true);
        gmEntity.setGmType("2");
        gmEntity.setLoginTotal(0);
        gmEntity.setGmNickname(addGmDto.getGmNickname());
        gmEntity.setGmPassword(SecurityUtils.encryptPassword(addGmDto.getGmPassword()));
        return gmEntity;
    }
    private GmMsgEntity get3(AddGmDto addGmDto,UserGmEntity userGmEntity){
        GmMsgEntity gmMsgEntity = new GmMsgEntity();
        gmMsgEntity.setGmId(userGmEntity.getId());
        gmMsgEntity.setDelFlag(0);
        gmMsgEntity.setGmPhone(addGmDto.getGmPhone());
        gmMsgEntity.setGmEmail(addGmDto.getGmEmail());
        return gmMsgEntity;
    }

    @Override
    public R logoutGm(){
        HttpServletRequest request = ServletUtils.getRequest();
        LoginUserToken loginUserToken =  tokenService.getLoginUserToken(request);
        tokenService.deleteToken(loginUserToken);
        return R.success("退出成功！");
    }
    @Override
    public R getGmSelfMsg(){
        Integer id = SecurityUtils.getUserId();
        GmEntity gmEntity = gmMapper.selectById(id);
        GmMsgEntity gmMsgEntity = gmMsgMapper.selectById(id);
        if (ObjectUtils.isNull(gmMsgEntity)||ObjectUtils.isNull(gmEntity)){
            return R.error("用户异常");
        }
        MsgVo msgVo = get1(gmEntity,gmMsgEntity);
        return R.success(msgVo);
    }
    private MsgVo get1(GmEntity gmEntity,GmMsgEntity gmMsgEntity){
        MsgVo msgVo = new MsgVo();
        msgVo.setAccount(gmEntity.getGmAccount());
        msgVo.setNickname(gmEntity.getGmNickname());
        msgVo.setLastLoginIp(gmEntity.getLastLoginIp());
        msgVo.setLastLoginTime(gmEntity.getLastLoginTime());
        msgVo.setPhone(gmMsgEntity.getGmPhone());
        msgVo.setEmail(gmMsgEntity.getGmEmail());
        RoleEntity roleEntity = roleMapper.selectById(gmEntity.getGmType());
        msgVo.setRole(roleEntity.getRoleName());
        msgVo.setAvatarUrl("https://picabstract-preview-ftn.weiyun.com/ftn_pic_abs_v3/1060da23f3b113b2b5b463a79362a585073ab63910848e4cde3592cebca6e86ec9606c33bc453f781041bee899c21f71?pictype=scale&from=30113&version=3.3.3.3&fname=tx.jpg&size=750");
        return msgVo;
    }
}
