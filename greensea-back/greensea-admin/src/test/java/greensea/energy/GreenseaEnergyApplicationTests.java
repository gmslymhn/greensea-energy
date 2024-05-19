package greensea.energy;

import greensea.energy.common.utils.RedisUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GreenseaEnergyApplicationTests {

    @Autowired
    private RedisUtils redisUtils;

    @Test
    public void test() {
//        ResourceEntity resourceEntity = new ResourceEntity();
//        resourceEntity.setResourceDescription("3213123");
//        resourceEntity.setResourceName("321");
//        redisUtils.setCacheObject("resourceKey",resourceEntity);
        redisUtils.setCacheObject("yourKey", 321, 15, TimeUnit.MINUTES);
//        redisUtils.setCacheObject("yourKey", 3211, 15, TimeUnit.MINUTES);
//        redisUtils.deleteObject("321");
        System.out.println(redisUtils.getCacheObject("yourKey"));
//        LoginUserToken loginUserToken = (LoginUserToken) redisUtils.getCacheObject("login_tokens:FEHZwC5k3a");
//
//        System.out.println(loginUserToken);
//        System.out.println(redisUtils.getCacheObject("login_user:1761687939071496194"));
//        System.out.println(redisUtils.hasKey("login_tokens:FEHZwC5k3a"));
    }

}
