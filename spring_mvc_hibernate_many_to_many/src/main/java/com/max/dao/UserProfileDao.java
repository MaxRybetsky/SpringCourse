package com.max.dao;

import com.max.model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfileDao extends JpaRepository<UserProfile, Integer> {
    UserProfile findByType(String type);
}
