package com.itheima.mm.service;

import com.itheima.mm.dao.UserDao;
import com.itheima.mm.pojo.User;
import com.itheima.mm.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;

public class UserService {
    public User init(User user) throws IOException {
        SqlSession session = MybatisUtils.openSqlSession();
        UserDao mapper = session.getMapper(UserDao.class);
        User user1=mapper.loginUser(user);
        MybatisUtils.commitAndClose(session);
        return user1;
    }
}
