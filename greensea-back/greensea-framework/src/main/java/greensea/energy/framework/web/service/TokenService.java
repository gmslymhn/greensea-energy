package greensea.energy.framework.web.service;

import greensea.energy.common.utils.RedisUtils;
import greensea.energy.framework.jwt.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @ClassName: TokenService
 * @Description:
 * @Author: gmslymhn
 * @CreateTime: 2024-05-19 22:17
 * @Version: 1.0
 **/
@Component
@Slf4j
public class TokenService {
    @Autowired
    private RedisUtils redisUtils;
    @Autowired
    private JwtUtil jwtUtil;
}
