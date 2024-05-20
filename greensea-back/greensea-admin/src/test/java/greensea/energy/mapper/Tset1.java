package greensea.energy.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import greensea.energy.framework.domain.entity.GmEntity;
import greensea.energy.framework.jwt.JwtUtil;
import greensea.energy.framework.mapper.GmMapper;
import greensea.energy.framework.mapper.RoleMapper;
import greensea.energy.framework.mapper.UserGmMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * @ClassName: Tset1
 * @Description:
 * @Author: gmslymhn
 * @CreateTime: 2024-05-19 17:24
 * @Version: 1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class Tset1 {
    @Autowired
    private GmMapper gmMapper;
    @Autowired
    private UserGmMapper userGmMapper;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private RoleMapper roleMapper;
    @Test
    public void testInsert() {
        GmEntity gmEntity = new GmEntity();
        gmEntity.setGmAccount("321");
        gmMapper.insert(gmEntity);
    }
    @Test
    public void testPage() {
        Page<GmEntity> page = new Page<>(1, 2);
        IPage<GmEntity> userIPage = gmMapper.selectPage(page, new QueryWrapper<GmEntity>());
        assertThat(page).isSameAs(userIPage);
        System.out.println("总条数: " + userIPage.getTotal());
        System.out.println("当前页数: " + userIPage.getCurrent());
        System.out.println("当前每页显示数: " + userIPage.getSize());
        System.out.println("记录列表: " + userIPage.getRecords());
    }
    @Test
    public void testJwt(){
        String token = jwtUtil.generateToken("321");
        System.out.println(token);
        System.out.println(jwtUtil.getToken(token));
    }
    @Test
    public void test1(){
        System.out.println(roleMapper.selectById(1));
    }
}
