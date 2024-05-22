package greensea.energy.framework.controller.background.user;

import greensea.energy.common.domain.R;
import greensea.energy.framework.domain.dto.AddUserDto;
import greensea.energy.framework.domain.dto.UserLoginDto;
import greensea.energy.framework.domain.dto.VerifyRegisterDto;
import greensea.energy.framework.service.IDirectoryService;
import greensea.energy.framework.service.IUserService;
import greensea.energy.framework.web.SecurityUtils;
import greensea.energy.framework.web.service.LoginService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName: UserController
 * @Description:
 * @Author: gmslymhn
 * @CreateTime: 2024-05-20 10:58
 * @Version: 1.0
 **/
@RestController
@Tag(name = "用户")
@RequestMapping("background/user")
@Slf4j
public class UserController {
    @Autowired
    private IUserService iUserService;
    @Autowired
    private LoginService loginService;
    @Autowired
    private IDirectoryService iDirectoryService;

    @PostMapping("/login")
    @Operation(summary = "用户登陆")
    public R login(@RequestBody @Validated UserLoginDto userLoginDto) {
        R verifyr = loginService.mayLogin(userLoginDto.getUserAccount());
        if (verifyr.getCode()!=200){
            return verifyr;
        }
        R r = iUserService.loginUser(userLoginDto);
        return r;
    }

    @PostMapping("/logout")
    @Operation(summary = "管理员登出")
    public R logout() {
        R r = iUserService.logoutUser();
        return r;
    }
    @PostMapping("/register")
    @Operation(summary = "用户注册")
    public R register(@RequestBody @Validated AddUserDto addUserDto) {
        R verifyr = loginService.mayRegister(addUserDto.getUserAccount(), addUserDto.getUserEmail(),addUserDto.getVerificationCode());
        if (verifyr.getCode()!=200){
            return verifyr;
        }
        R r = iUserService.addUser(addUserDto);
        return r;
    }

    @PostMapping("/register/verify")
    @Operation(summary = "用户注册验证")
    public R verifyRegister(@RequestBody @Validated VerifyRegisterDto verifyRegister) {
        R verifyr = loginService.mayRegisterVerify();
        if (verifyr.getCode()!=200){
            return verifyr;
        }

        R r = iUserService.verifyRegister(verifyRegister.getUserAccount(),verifyRegister.getUserEmail());
        return r;
    }

    @PreAuthorize("@ss.hasLoginType('B')")
    @PostMapping("/getselfdirectory")
    @Operation(summary = "获取自己的后台目录",description = "获取用户自己的后台目录")
    public R getSelfDirectory() {
        if (SecurityUtils.getPermission().equals("enterprise")){
            return iDirectoryService.getDirectory(3);
        }else if(SecurityUtils.getPermission().equals("personal")){
            return iDirectoryService.getDirectory(4);
        }
        return R.error("系统异常！");
    }

    @PostMapping("/test")
    @Operation(summary = "测试")
    public R test() {
        return R.success();
    }



}
