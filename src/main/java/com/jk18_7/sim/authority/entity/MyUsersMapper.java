package com.jk18_7.sim.authority.entity;

import com.jk18_7.sim.login.entity.Users;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MyUsersMapper implements RowMapper<Users> {
    @Override
    public Users mapRow(ResultSet resultSet, int i) throws SQLException {
        Users users = new Users();
        users.setuId(resultSet.getInt(1));
        users.setuName(resultSet.getString(2));
        users.setuPwd(resultSet.getString(3));
        users.setuEmail(resultSet.getString(4));
        users.setSalt(resultSet.getString(5));
        return users;
    }
}
