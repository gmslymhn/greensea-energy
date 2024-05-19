package greensea.energy.framework.jwt.security;

import cn.hutool.json.JSONUtil;
import greensea.energy.common.domain.R;
import greensea.energy.common.domain.ResponseCode;
import greensea.energy.common.utils.http.ServletUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @ClassName: JwtAuthenticationEntryPoint
 * @Description:
 * @Author: gmslymhn
 * @CreateTime: 2024-05-19 18:47
 * @Version: 1.0
 **/
@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
//        response.setContentType("application/json;charset=UTF-8");

        String msg = "请先登录！";

        ServletUtils.renderString(response, JSONUtil.toJsonStr(R.error(ResponseCode.Unauthorized,msg)));
    }
}
