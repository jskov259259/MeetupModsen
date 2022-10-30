package com.modsen.meetup.config;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

@Configuration
@Profile("dev")
public class TestConfig {

    @Bean
    public DataSource dataSource() {
        try {
            EmbeddedDatabaseBuilder dbBuilder = new EmbeddedDatabaseBuilder();
            return dbBuilder.setType(EmbeddedDatabaseType.H2)
                    .addScripts("create-db.sql",
                            "init-db.sql").build();
        } catch (Exception е) {
            return null;
        }
    }


    private Properties hibernateProperties() {
        Properties hibernateProp = new Properties();
        hibernateProp.put("hibernate.dialect",
                "org.hibernate.dialect.H2Dialect");
        hibernateProp.put("hibernate.format sql", true);
        hibernateProp.put("hibernate.use sql comments", true);
        hibernateProp.put("hibernate.show_sql", true);
        hibernateProp.put("hibernate.max fetch_depth", 3);
        hibernateProp.put("hibernate. jdbc.batch size", 10);
        hibernateProp.put("hibernate.jdbc. fetch_size", 50);
        return hibernateProp;
    }

    @Bean
    public SessionFactory sessionFactory() throws IOException {
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource());
        sessionFactoryBean.setHibernateProperties(
                hibernateProperties());
        sessionFactoryBean.setPackagesToScan(
                "com.modsen.meetup.model");
        sessionFactoryBean.afterPropertiesSet();
        return sessionFactoryBean.getObject();
    }

    @Bean
    public PlatformTransactionManager transactionManager() throws IOException {
        return new HibernateTransactionManager(sessionFactory());
    }
}
