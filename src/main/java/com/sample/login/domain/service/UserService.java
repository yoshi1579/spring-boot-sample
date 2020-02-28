package com.sample.login.domain.service;

import com.sample.login.domain.model.User;
import com.sample.login.domain.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public Boolean insertOne(User user){
        Boolean result = false;

        Integer rowNumber = userDao.insertOne(user);
        if(rowNumber > 0){
            result = true;
        }
        return result;
    }

    public Integer count() {
        return userDao.count();
    }

    public User selectOne(Integer id) {
        return userDao.selectOne(id);
    }

    public List<User> selectMany() {
        return userDao.selectMany();
    }

    public boolean updateOne(User user){
        int rowNumber = userDao.updateOne(user);
        boolean result = false;

        if(rowNumber > 0)
            result = true;
        return result;
    }
}
