package com.sample.login.domain.repository;

import com.sample.login.domain.model.User;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface UserDao {

    public Integer count() throws DataAccessException;
    public Integer insertOne(User user) throws DataAccessException;
    public Integer updateOne(User user) throws DataAccessException;
    public User selectOne(Integer id) throws DataAccessException;
    public List<User> selectMany() throws DataAccessException;
}
