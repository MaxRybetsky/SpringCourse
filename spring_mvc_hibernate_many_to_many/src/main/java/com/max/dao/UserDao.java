package com.max.dao;

import com.max.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Integer> {
    User findBySSO(String sso);

    void deleteBySSO(String sso);
}
