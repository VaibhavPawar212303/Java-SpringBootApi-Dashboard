package com.example.entities;

public class BuildData {
    private String projectType;
    private String projectId;
    private String buildName;
    private String buildStatus;
   
    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getBuildName() {
        return buildName;
    }

    public void setBuildName(String buildName) {
        this.buildName = buildName;
    }

    public String getBuildStatus() {
        return buildStatus;
    }

    public void setBuildStatus(String buildStatus) {
        this.buildStatus = buildStatus;
    }
}
