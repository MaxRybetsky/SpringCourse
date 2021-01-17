package com.max.model;

public enum UserProfileType {
    USER("USER"),
    DBA("DBA"),
    ADMIN("ADMIN");

    private String userProfileType;

    private UserProfileType(String userTypeProfile) {
        this.userProfileType = userTypeProfile;
    }

    public String getUserProfileType() {
        return userProfileType;
    }
}
