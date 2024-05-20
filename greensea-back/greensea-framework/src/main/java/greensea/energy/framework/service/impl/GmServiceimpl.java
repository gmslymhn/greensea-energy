package greensea.energy.framework.service.impl;

import greensea.energy.common.domain.R;
import greensea.energy.common.utils.http.ServletUtils;
import greensea.energy.framework.domain.dto.AddGmDto;
import greensea.energy.framework.domain.dto.GmLoginDto;
import greensea.energy.framework.domain.model.LoginUser;
import greensea.energy.framework.domain.model.LoginUserToken;
import greensea.energy.framework.jwt.security.AuthenticationContextHolder;
import greensea.energy.framework.mapper.GmMapper;
import greensea.energy.framework.mapper.GmMsgMapper;
import greensea.energy.framework.service.IGmService;
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
            String token = tokenService.createToken(loginUser);
            Map<String, String> map = new HashMap<>();
            map.put("token", token);
            return R.success(map);
        }
        return R.error("账号异常！");
    }
    public R addGm(AddGmDto addGmDto){

        return R.success("添加成功！");
    }

    @Override
    public R logoutGm(){
        HttpServletRequest request = ServletUtils.getRequest();
        LoginUserToken loginUserToken =  tokenService.getLoginUserToken(request);
        tokenService.deleteToken(loginUserToken);
        return R.success("退出成功！");
    }

}
