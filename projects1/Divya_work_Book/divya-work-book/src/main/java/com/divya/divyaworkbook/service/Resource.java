package com.divya.divyaworkbook.service;

public class Resource {
    private String resourceName;
    private int resourceAge;

    public Resource() {
    }

    public Resource(String resourceName, int resourceAge) {
        this.resourceName = resourceName;
        this.resourceAge = resourceAge;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public int getResourceAge() {
        return resourceAge;
    }

    public void setResourceAge(int resourceAge) {
        this.resourceAge = resourceAge;
    }
}
