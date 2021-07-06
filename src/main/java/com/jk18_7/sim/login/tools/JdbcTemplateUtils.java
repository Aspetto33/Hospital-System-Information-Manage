package com.jk18_7.sim.login.tools;

import com.mchange.v2.c3p0.DataSources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class JdbcTemplateUtils {

    public JdbcTemplate getJdbcTemplate(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext-spring.xml");
        DataSource dataSource = (DataSource) applicationContext.getBean("dataSource");
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        return jdbcTemplate;
    }

}
