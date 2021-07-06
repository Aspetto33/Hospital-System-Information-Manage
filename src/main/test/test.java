import com.jk18_7.sim.authority.entity.MyUsersMapper;
import com.jk18_7.sim.hospital.entity.Hospital;
import com.jk18_7.sim.hospital.service.HospitalService;
import com.jk18_7.sim.login.entity.Users;
import com.jk18_7.sim.login.service.LoginService;
import com.jk18_7.sim.login.tools.JdbcTemplateUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Transactional
public class test {
    @Transactional(readOnly = true)
   @Test
    public void test(){
//       Hospital hospital = new Hospital();
//       HospitalDao hospitalDao = new HospitalDaoImpl();
//       String h = "1999-03-23";
//       Date date = Date.valueOf(h);
//       hospital.setdCount(15);
//       hospital.setDeCount(49);
//       hospital.sethArea(3949);
//       hospital.sethTime(date);
//       hospitalDao.addHospital(hospital);
//       System.out.println("success");
//       for (Hospital hospital2:hospital1){
//           System.out.println(hospital2.getdCount());
//           System.out.println(hospital2.gethId());
//       }
//       HibernateUtils hibernateUtils = new HibernateUtils();
//       Session session = hibernateUtils.getSession();
//       System.out.println(session);

//       ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext-spring.xml");
//       HospitalService hospitalService = (HospitalService) ctx.getBean("hospitalService",HospitalService.class);
//       SessionFactory sessionFactory = (SessionFactory) ctx.getBean("sessionFactory");
//       Session session = sessionFactory.getCurrentSession();
//       Transaction transaction = session.beginTransaction();
//       System.out.println(sessionFactory);
//       System.out.println(loginService);
//       Users users = new Users();
//       users.setuName("qian");
//       users.setuPwd("yangqian123");
//       users.setuEmail("1760906445@qq.com");
//       session.save(users);
//       transaction.commit();
//       loginService.AddUser(users);
//       System.out.println("success");
//      hospitalService.deleteHospital(16);
//      String h = "2020-12-20";
//      hospitalService.addHospital(hospital);

//       ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext-shiro.xml");
//       Subject subject = SecurityUtils.getSubject();
//        UsernamePasswordToken token = new UsernamePasswordToken("qian123","yangqian123");
//        try {
//            subject.login(token);
//            Session session = subject.getSession();
//            session.setAttribute("subject", subject);
//        }catch (AuthenticationException e){
//            System.out.println("认证失败");
//
//        }
//       ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext-spring.xml");
//       SessionFactory sessionFactory = (SessionFactory) applicationContext.getBean("sessionFactory");
//       Session session = sessionFactory.openSession();
//       Query query = session.createQuery("from Users where uName = :uname");
//       query.setParameter("uname","qian123");
//       List<Users> list = query.list();
//       System.out.println(list);
//       session.close();

//        JdbcTemplateUtils jdbcTemplateUtils = new JdbcTemplateUtils();
//        JdbcTemplate jdbcTemplate = jdbcTemplateUtils.getJdbcTemplate();
//        String sql = "select * from users where u_name=?";
//        List<Map<String,Object>> list = jdbcTemplate.queryForList(sql,"qian123");
//        System.out.println(list);
//        JdbcTemplateUtils jdbcTemplateUtils = new JdbcTemplateUtils();
//        JdbcTemplate jdbcTemplate = jdbcTemplateUtils.getJdbcTemplate();
//        String sql = "select * from users where u_name=? and u_pwd=?";
//        List<Map<String,Object>> list1 = jdbcTemplate.queryForList(sql,"qian123","yangqian123");
//        System.out.println(list1);

//        ApplicationContext applicationContext1 = new ClassPathXmlApplicationContext("applicationContext-spring.xml");
//        LoginService loginService = (LoginService) applicationContext1.getBean("loginService");
//        UsernamePasswordToken t = (UsernamePasswordToken) token;
//        String userName= token.getPrincipal().toString();
//        //获取数据库中的密码
//        Users users =loginService.FindUserByName(userName);
//        String passwordInDB = users.getuPwd();
//        String salt = users.getSalt();
//        //认证信息里存放账号密码, getName() 是当前Realm的继承方法,通常返回当前类名 :userRealm
//        //盐也放进去
//        //这样通过applicationContext-shiro.xml里配置的 HashedCredentialsMatcher 进行自动校验
//        SimpleAuthenticationInfo a = new SimpleAuthenticationInfo(userName,passwordInDB, ByteSource.Util.bytes(salt),getName());
//        JdbcTemplateUtils jdbcTemplateUtils = new JdbcTemplateUtils();
//        JdbcTemplate jdbcTemplate = jdbcTemplateUtils.getJdbcTemplate();
//        String sql = "select * from users where u_name=?";
//        Users list = jdbcTemplate.queryForObject(sql, new MyUsersMapper(),"qian123");
//        System.out.println(list.getSalt()+"盐值 ");
//        System.out.println(list.getuName()+"用户名");
//        System.out.println(list.getuEmail()+"电子邮箱");
//        System.out.println(list.getuPwd()+"密码");

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext-spring.xml");
        LoginService loginService = (LoginService) applicationContext.getBean("loginService");
        String upwd = loginService.UpdateUpwd("qian123","yangqian123","12345678");
        System.out.println(upwd);
        Users users = loginService.FindUserByName("qian123");
        System.out.println(users);
   }
}
