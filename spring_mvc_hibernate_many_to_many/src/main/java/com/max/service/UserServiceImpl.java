package com.max.service;

import com.max.dao.UserDao;
import com.max.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User findById(int id) {
        return userDao.findById(id).orElse(null);
    }

    @Override
    public User findBySSO(String sso) {
        return userDao.findBySSO(sso);
    }

    @Override
    public void saveUser(User user) {
        userDao.save(user);
    }

    @Override
    public void deleteUserBySSO(String sso) {
        userDao.deleteBySSO(sso);
    }

    @Override
    public List<User> findAllUsers() {
        return userDao.findAll();
    }

    @Override
    public boolean isUserSSOUnique(Integer id, String sso) {
        User user = findBySSO(sso);
        return (user == null || (user.getId().equals(id)));
    }
}
