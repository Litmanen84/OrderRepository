package com.example.orderproject.users.enums;

import java.util.List;

public enum Role {
    USER("User", List.of(Feature.BASIC_ACCESS, Feature.CREATE_ORDER)),
    ADMIN("Admin", List.of(Feature.BASIC_ACCESS,Feature.CREATE_ORDER, Feature.ADD_ITEM, Feature.SEE_ALL_USERS, Feature.SEE_USER_DETAILS));

    private String role;
    private List<Feature> features;

    Role(String role, List<Feature> features) {
        this.role = role;
        this.features = features;
    }

    public String getRole() {
        return role;
    }

    public boolean hasFeature(Feature feature) {
        return features.contains(feature);
    }
}
