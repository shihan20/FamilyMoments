package config;

import data.DataMapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * Created by shihan on 16/4/16.
 */
@Configuration
@ComponentScan({"service", "data"})
public class RootConfig {
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource("jdbc:mysql://localhost:3306/hibernate?useUnicode=true&amp;characterEncoding=UTF-8", "root", "");
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        return dataSource;
    }

    @Bean
    public DataSourceTransactionManager transactionManager(DataSource dataSource){
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager(dataSource);
        return transactionManager;
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource) {
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(dataSource);
        sqlSessionFactory.setConfigLocation(new ClassPathResource("/data/mybatis-config.xml"));
        return sqlSessionFactory;
    }

    @Bean
    public MapperFactoryBean dataMapper(SqlSessionFactory sqlSessionFactory) {
        MapperFactoryBean dataMapper = new MapperFactoryBean();
        dataMapper.setMapperInterface(DataMapper.class);
        dataMapper.setSqlSessionFactory(sqlSessionFactory);
        return dataMapper;
    }
}
