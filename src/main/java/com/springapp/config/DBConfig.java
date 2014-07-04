package com.springapp.config;

import com.springapp.config.enums.DBEnum;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@ComponentScan("com.springapp")
@PropertySource("classpath:db.properties")
@EnableJpaRepositories("com.springapp.repository")
public class DBConfig {

    @Resource
    private Environment env;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource= new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getRequiredProperty(DBEnum.PROP_DATABASE_DRIVER.toSring()));
        dataSource.setUrl(env.getRequiredProperty(DBEnum.PROP_DATABASE_URL.toSring()));
        dataSource.setUsername(env.getRequiredProperty(DBEnum.PROP_DATABASE_USERNAME.toSring()));
        dataSource.setPassword(env.getRequiredProperty(DBEnum.PROP_DATABASE_PASSWORD.toSring()));

        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource());
        entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        entityManagerFactoryBean.setPackagesToScan(env.getRequiredProperty(DBEnum.PROP_ENTITYMANAGER_PACKAGES_TO_SCAN.toSring()));
        entityManagerFactoryBean.setJpaProperties(getHibernateProperties());

        return entityManagerFactoryBean;
    }

    @Bean
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());

        return transactionManager;
    }

    private Properties getHibernateProperties() {
        Properties properties = new Properties();
        properties.put(DBEnum.PROP_HIBERNATE_DIALECT.toSring(), env.getRequiredProperty(DBEnum.PROP_HIBERNATE_DIALECT.toSring()));
        properties.put(DBEnum.PROP_HIBERNATE_SHOW_SQL.toSring(), env.getRequiredProperty(DBEnum.PROP_HIBERNATE_SHOW_SQL.toSring()));
        properties.put(DBEnum.PROP_HIBERNATE_HBM2DDL_AUTO.toSring(), env.getRequiredProperty(DBEnum.PROP_HIBERNATE_HBM2DDL_AUTO.toSring()));
        properties.put(DBEnum.PROP_HIBERNATE_QUOTED_IND.toSring(), env.getRequiredProperty(DBEnum.PROP_HIBERNATE_QUOTED_IND.toSring()));

        return  properties;
    }

}
