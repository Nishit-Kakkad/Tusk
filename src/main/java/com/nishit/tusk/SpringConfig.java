/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nishit.tusk;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import java.util.Properties;
import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 *
 * @author Nishit-TCS
 */
@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = {"com.nishit.tusk.Controller", "com.nishit.tusk.dao", "com.nishit.tusk.entity, com.nishit.tusk"})
public class SpringConfig implements WebMvcConfigurer{
    
    @Autowired
    private Environment environment;
    
    @Bean
    public ViewResolver resolver() {
        InternalResourceViewResolver resolve = new InternalResourceViewResolver();
        resolve.setViewClass(JstlView.class);
        resolve.setPrefix("");
        resolve.setSuffix(".jsp");
        return resolve;
    }
    
    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
        localSessionFactoryBean.setDataSource(dataSource());
        localSessionFactoryBean.setPackagesToScan(new String[] { "com.nishit.tusk.entity", "com.nishit.tusk" });
        localSessionFactoryBean.setHibernateProperties(hibernateProperties());
        return localSessionFactoryBean;
    }
    
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/nishit?autoReconnect=true&useSSL=false");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        return dataSource;
    } 
    
    @Bean
    public Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL57Dialect");
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.format_sql", "true");
        properties.put("hibernate.hbm2ddl.auto", "create");
        properties.put("hibernate.connection.pool_size", 20);
        return properties;
    }
    
    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory s) {
        HibernateTransactionManager txManager = new HibernateTransactionManager(s);
        return txManager;
    }
}
