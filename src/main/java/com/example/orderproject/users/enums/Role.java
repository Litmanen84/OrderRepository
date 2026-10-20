package com.example.orderproject.users.enums;

import java.util.List;

public enum Role {
    USER("User", List.of(Feature.DELETE_USER)),
    ADMIN("Admin", List.of(Feature.DELETE_USER, Feature.REGISTER_ADMIN));

    private String role;
    private List<Feature> features;

    Role(String role, List<Feature> features) {
        this.role = role;
        this.features = features;
    }

    public boolean hasFeature(Feature feature) {
        return features.contains(feature);
    }
}
