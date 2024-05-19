package greensea.energy.framework.jwt.security;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import greensea.energy.framework.jwt.JwtUtil;
import io.jsonwebtoken.Claims;
import jakarta.annotation.Resource;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: JwtAuthenticationFilter
 * @Description:
 * @Author: gmslymhn
 * @CreateTime: 2024-05-19 18:48
 * @Version: 1.0
 **/
@Slf4j
@Component
public class JwtAuthenticationFilter  extends OncePerRequestFilter {
    @Resource
    private JwtUtil jwtUtil;
//    @Autowired
//    private TokenService tokenService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader(jwtUtil.gerHeader());
        // 未获取到token，继续往后走，因为后面还有鉴权管理器等去判断是否拥有身份凭证，所以可以放行
        // 没有token相当于匿名访问，若有一些接口是需要权限的，则不能访问这些接口
        if (StrUtil.isBlankOrUndefined(token)) {
            filterChain.doFilter(request, response);
            return;
        }
//        log.info(token);
//        Claims claims = jwtUtil.getClaimsByToken(token);
//        if (claims == null) {
//            throw new BaseException(ResponseCode.Bad_Request, "token异常");
//        }
//        if (jwtUtil.isTokenExpired(claims.getExpiration())) {
//
//            LoginUserToken loginUserToken =  tokenService.getLoginUserToken(request);
//            if (ObjectUtils.isNotNull(loginUserToken)){
//                String token1 = tokenService.refreshToken(loginUserToken);
//                Map<String, String> map = new HashMap<>();
//                map.put("token", token1);
//                R r = new R();
//                r.setCode(ErrorCode.TOKEN_OVERDUE);
//                r.setMessage("token重新授权。");
//                r.setData(map);
//                ServletUtils.renderString(response, JSONUtil.toJsonStr(r));
//                return;
//            }else {
//                String msg = "token已过期,请重新登陆!";
//                ServletUtils.renderString(response, JSONUtil.toJsonStr(R.error(ResponseCode.Unauthorized,msg)));
//                return;
//            }
//
//        }
//        LoginUser loginUser = tokenService.getLoginUser(request);
//
//        log.info(String.valueOf(loginUser));
//        if (ObjectUtils.isNull(loginUser)){
//            String msg = "请重新登陆!";
//            ServletUtils.renderString(response, JSONUtil.toJsonStr(R.error(ResponseCode.Unauthorized,msg)));
//            return;
//        }

        // 构建UsernamePasswordAuthenticationToken，这里密码为null，是因为提供了正确的token，实现自动登录
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(null, null, null);
        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        filterChain.doFilter(request, response);
    }
}
