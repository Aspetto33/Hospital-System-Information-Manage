package com.jk18_7.sim.login.tools;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
@Transactional
public class HibernateUtils {
//    @Resource(name="sessionFactory")
//    private  SessionFactory sessionFactory;
//    ApplicationContext applicationContext =new ClassPathXmlApplicationContext("applicationContext-spring.xml");
//    SessionFactory sessionFactory = (SessionFactory) applicationContext.getBean("sessionFactory");

//    public  Session getSession(){
//        Session session = sessionFactory.getCurrentSession();
//        return session;
//    }
}
