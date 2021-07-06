package com.jk18_7.sim.login.dao;

import com.jk18_7.sim.authority.entity.MyUsersMapper;
import com.jk18_7.sim.login.entity.Users;
import com.jk18_7.sim.login.interfaces.LoginDao;
import com.jk18_7.sim.login.tools.HibernateUtils;
import com.jk18_7.sim.login.tools.JdbcTemplateUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository("loginDao")
public class LoginDaoImpl implements LoginDao {
    //Getting objects by annotation
//    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext-spring.xml");
//    SessionFactory sessionFactory = (SessionFactory) applicationContext.getBean("sessionFactory");
    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;
    @Override
    public Boolean FindUserByUnameAndUpwd(String uname, String upwd) {
        try{
            JdbcTemplateUtils jdbcTemplateUtils = new JdbcTemplateUtils();
            JdbcTemplate jdbcTemplate = jdbcTemplateUtils.getJdbcTemplate();
            String sql = "select * from users where u_name=? and u_pwd=?";
            List<Map<String,Object>> list1 = jdbcTemplate.queryForList(sql,uname,upwd);

            if(list1.size()>0){
                return true;
            }else {
                return false;
            }
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public void AddUser(Users users) {
        JdbcTemplateUtils jdbcTemplateUtils = new JdbcTemplateUtils();
        JdbcTemplate jdbcTemplate = jdbcTemplateUtils.getJdbcTemplate();
        try {
            String sql = "insert into users(u_name,u_pwd,u_email,salt) values(?,?,?,?)";
            String salt = new SecureRandomNumberGenerator().nextBytes().toString();
            int times = 2;
            String algorithmName = "md5";
            String encodedPassword = new SimpleHash(algorithmName, users.getuPwd(),salt,times).toString();
            String[] info = {users.getuName(),encodedPassword, users.getuEmail(),salt};
            jdbcTemplate.update(sql,info);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String UpdateUpwd(String uname,String upwd,String newupwd) {
        Users users = FindUserByName(uname);
        if(users == null){
            System.out.println("账号错误");
            return "500";
        }else if(users!= null){
            String salt = users.getSalt();
            int times = 2;
            String algorithmName = "md5";
            String encodedPassword = new SimpleHash(algorithmName,upwd,salt,times).toString();
            if(!encodedPassword.equals(users.getuPwd())){
                System.out.println("原密码错误");
                return "201";
            }else {
                UsernamePasswordToken token = new UsernamePasswordToken(uname,newupwd);
                String  newpwd = new SimpleHash(algorithmName,newupwd,salt,times).toString();
                users.setuPwd(newpwd);
                JdbcTemplateUtils jdbcTemplateUtils = new JdbcTemplateUtils();
                JdbcTemplate jdbcTemplate = jdbcTemplateUtils.getJdbcTemplate();
                String sql = "update users set u_pwd=? where u_name=?";
                jdbcTemplate.update(sql,newpwd,uname);
                return newpwd;
            }
        }else{
            return "";
        }
    }

    @Override
    public Users FindUserByName(String uname) {
        JdbcTemplateUtils jdbcTemplateUtils = new JdbcTemplateUtils();
        JdbcTemplate jdbcTemplate = jdbcTemplateUtils.getJdbcTemplate();
        String sql = "select * from users where u_name=?";
        Users list = jdbcTemplate.queryForObject(sql, new MyUsersMapper(),uname);
        if(list == null)
            return null;
        return list;
    }

    @Override
    public String getPassword(String uname) {
        Users users = FindUserByName(uname);
        if(users == null)
            return null;
        return users.getuPwd();

    }

    @Override
    public void updateUser(Users users) {

    }

    @Override
    public Users getUser(long uid) {
        Session session = sessionFactory.openSession();
        String sql = "from Users where uId=:uid";
        Query query = session.createQuery(sql);
        query.setParameter("uid",uid);
        List<Users> list = query.list();
        session.close();
        if(list.size()<=0 || list == null)
            return null;
        return list.get(0);
    }

    @Override
    public List<Users> getList() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Users");
        List list = query.list();
        if(list.size()<=0 || list == null)
            return null;
        return list;

    }


}
