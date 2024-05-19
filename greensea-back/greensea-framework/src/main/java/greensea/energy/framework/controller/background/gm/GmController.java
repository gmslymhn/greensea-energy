package greensea.energy.framework.controller.background.gm;

import greensea.energy.common.domain.R;
import greensea.energy.framework.domain.dto.GmLoginDto;
import greensea.energy.framework.service.IGmService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
    @PostMapping("/login")
    @Operation(summary = "登陆")
    public R login(@RequestBody @Validated GmLoginDto gmLoginDto) {
        R r = iGmService.loginGm(gmLoginDto);
        return r;
    }
}
