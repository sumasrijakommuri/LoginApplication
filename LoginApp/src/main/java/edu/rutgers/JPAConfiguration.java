package edu.rutgers;

import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.*;
import org.springframework.orm.jpa.*;
import org.springframework.orm.jpa.vendor.*;
import org.springframework.transaction.*;
import org.springframework.transaction.annotation.*;

import javax.persistence.*;
import javax.sql.*;
import java.util.*;

/**
 * Created by Srija on 9/26/2017.
 */
@Configuration
@EnableTransactionManagement
public class JPAConfiguration {

    @Bean
    public LocalContainerEntityManagerFactoryBean getEMF(){
        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();

        emf.setDataSource(getDataSource());
        emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        emf.setPackagesToScan("edu.rutgers.Entity");

        Properties properties = new Properties();
        properties.put("hibernate.hbm2ddl.auto","validate");
        properties.put("hibernate.show_sql","true");
        properties.put("hibernate.dialect","org.hibernate.dialect.MySQL57Dialect");

        emf.setJpaProperties(properties);

        return emf;
    }

    @Bean
    public DataSource getDataSource(){
        DriverManagerDataSource ds = new DriverManagerDataSource();

        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/loginapp?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
        ds.setUsername("root");
        ds.setPassword("");

        return ds;
    }

    @Bean
    public PlatformTransactionManager txmanager(EntityManagerFactory emf){
        JpaTransactionManager jtm = new JpaTransactionManager(emf);
        return jtm;
    }
}
