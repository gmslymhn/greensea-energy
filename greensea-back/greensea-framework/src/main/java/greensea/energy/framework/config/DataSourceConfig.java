package greensea.energy.framework.config;

import com.alibaba.druid.spring.boot3.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @ClassName: DataSourceConfig
 * @Description: 整合Druid
 * @Author: gmslymhn
 * @CreateTime: 2024-05-18 11:05
 * @Version: 1.0
 **/
@Configuration
public class DataSourceConfig {
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.druid")
    public DataSource getDataSource() {
        return DruidDataSourceBuilder.create().build();
    }
}