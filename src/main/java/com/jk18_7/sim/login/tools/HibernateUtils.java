package com.jk18_7.sim.login.tools;

import org.hibernate.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
@Transactional
public class HibernateUtils {
    private  SessionFactory sessionFactory = null;

    public Session getSession() throws HibernateException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext-spring.xml");
        sessionFactory = (SessionFactory) applicationContext.getBean("sessionFactory");
        Session session = sessionFactory.openSession();
        return session;

    }
    public void closeSession() throws HibernateException{
        Session session = getSession();
        if(session!=null){
            session.close();
        }
    }
}
