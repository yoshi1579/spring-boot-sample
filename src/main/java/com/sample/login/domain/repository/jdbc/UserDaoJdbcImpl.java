package com.sample.login.domain.repository.jdbc;

import com.sample.login.domain.model.User;
import com.sample.login.domain.model.UserRowMapper;
import com.sample.login.domain.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoJdbcImpl implements UserDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Integer count() throws DataAccessException{
        Integer count = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM user", Integer.class);
        return count;
    }

    @Override
    public Integer insertOne(User user) throws DataAccessException{
        Integer rowNumber = jdbcTemplate.update("INSERT INTO user(id,"
                + "age,"
                + "name,"
                + "userName,"
                + "password,"
                + "role)"
                + " VALUES(?,?,?,?,?,?)"
                , user.getId()
                , user.getAge()
                , user.getName()
                , user.getUserName()
                , user.getPassword()
                , user.getRole()
        );
        return rowNumber;
    }

    public User selectOne(Integer id) throws DataAccessException{
        UserRowMapper userRowMapper = new UserRowMapper();
        return jdbcTemplate.queryForObject("SELECT * FROM user WHERE id = ?;", userRowMapper, id);
    }

    public List<User> selectMany() throws DataAccessException{
        UserRowMapper userRowMapper = new UserRowMapper();
        return jdbcTemplate.query("SELECT * FROM user;", userRowMapper);
    }

    @Override
    public Integer updateOne(User user) throws DataAccessException{
        Integer rowNumber = jdbcTemplate.update("UPDATE user"
                        + " SET"
                        + " age = ?,"
                        + " name = ?,"
                        + " userName = ?,"
                        + " password = ?,"
                        + " role = ?"
                        + " WHERE ID = ?"
                , user.getAge()
                , user.getName()
                , user.getUserName()
                , user.getPassword()
                , user.getRole()
                , user.getId()
        );
        return rowNumber;
    }
}
