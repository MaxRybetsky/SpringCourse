package com.max.converter;

import com.max.model.UserProfile;
import com.max.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class RoleToUserProfileConverter implements Converter <Object, UserProfile>{

    private UserProfileService userProfileService;

    @Autowired
    public RoleToUserProfileConverter(UserProfileService userProfileService) {
        this.userProfileService = userProfileService;
    }

    @Override
    public UserProfile convert(Object o) {
        Integer id = Integer.parseInt((String) o);
        UserProfile profile = userProfileService.findById(id);
        System.out.println("Profile: " + profile);
        return profile;
    }
}
