package com.example.dto;

public class ProjectDTO {

	private Long userId;
	private String projectName;
	private String projectDesc;
	private String projectType;

	public ProjectDTO() {
	}

	public ProjectDTO(Long userId, String projectName, String projectDesc, String projectType) {
		this.userId = userId;
		this.projectName = projectName;
		this.projectDesc = projectDesc;
		this.projectType = projectType;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectDesc() {
		return projectDesc;
	}

	public void setProjectDesc(String projectDesc) {
		this.projectDesc = projectDesc;
	}

	public String getProjectType() {
		return projectType;
	}

	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}

	@Override
	public String toString() {
		return "ProjectDTO{" + "userId=" + userId + ", projectName='" + projectName + '\'' + ", projectDesc='"
				+ projectDesc + '\'' + ", projectType='" + projectType + '\'' + '}';
	}
}
