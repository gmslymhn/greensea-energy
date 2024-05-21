package greensea.energy.framework.controller.background.gm;

import greensea.energy.common.domain.R;
import greensea.energy.framework.domain.dto.AddGmDto;
import greensea.energy.framework.domain.dto.AddUserDto;
import greensea.energy.framework.domain.dto.GmLoginDto;
import greensea.energy.framework.service.IDirectoryService;
import greensea.energy.framework.service.IGmService;
import greensea.energy.framework.web.SecurityUtils;
import greensea.energy.framework.web.service.LoginService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: GmController
 * @Description:
 * @Author: gmslymhn
 * @CreateTime: 2024-05-19 19:06
 * @Version: 1.0
 **/
@RestController
@Tag(name = "管理员")
@RequestMapping("background/gm")
@Slf4j
public class GmController {
    @Autowired
    private IGmService iGmService;
    @Autowired
    private LoginService loginService;
    @Autowired
    private IDirectoryService iDirectoryService;
    @PostMapping("/login")
    @Operation(summary = "管理员登陆",description= "用于管理员登陆")
    public R login(@RequestBody @Validated GmLoginDto gmLoginDto) {
        R verifyr = loginService.mayLogin(gmLoginDto.getGmAccount());
        if (verifyr.getCode()!=200){
            return verifyr;
        }
        R r = iGmService.loginGm(gmLoginDto);
        return r;
    }
    @PostMapping("/logout")
    @Operation(summary = "管理员登出")
    public R logout() {
        R r = iGmService.logoutGm();
        return r;
    }

    @PreAuthorize("@ss.hasLoginType('A')")
    @PostMapping("/getselfdirectory")
    @Operation(summary = "获取自己的后台目录",description = "获取管理员自己的后台目录")
    public R getSelfDirectory() {
            if (SecurityUtils.getPermission().equals("admin")){
                return iDirectoryService.getGmDirectory(1);
            }else if(SecurityUtils.getPermission().equals("manager")){
                return iDirectoryService.getGmDirectory(2);
            }
        return R.error("系统异常！");
    }

    @PreAuthorize("@ss.hasPermission('admin')")
    @PostMapping("/addgm")
    @Operation(summary = "添加管理员")
    public R addGm(@RequestBody @Validated AddGmDto addGmDto) {
        R r = iGmService.addGm(addGmDto);
        return r;
    }
}
