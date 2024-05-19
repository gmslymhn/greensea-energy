package greensea.energy.framework.service.impl;

import greensea.energy.framework.mapper.UserMapper;
import greensea.energy.framework.mapper.UserMsgMapper;
import greensea.energy.framework.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
