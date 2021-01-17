package com.max.service;

import com.max.model.UserProfile;

import java.util.List;

public interface UserProfileService {
    UserProfile findById(int id);

    UserProfile findByType(String type);

    List<UserProfile> findAll();
}
