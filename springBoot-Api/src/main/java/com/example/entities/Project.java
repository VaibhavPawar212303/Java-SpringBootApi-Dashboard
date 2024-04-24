package com.example.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "projectdata")
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "user_id")
	private Long userId;

	@Column(name = "project_name")
	private String projectName;

	@Column(name = "project_desc")
	private String projectDesc;

	@Column(name = "project_type")
	private String projectType;

	@Column(name = "project_id")
	private Long projectId;

	public Project() {
	}

	public Project(Long userId, String projectName, String projectDesc, String projectType, Long projectId) {
		this.userId = userId;
		this.projectName = projectName;
		this.projectDesc = projectDesc;
		this.projectType = projectType;
		this.projectId = projectId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	@Override
	public String toString() {
		return "Project{" + "id=" + id + ", userId=" + userId + ", projectName='" + projectName + '\''
				+ ", projectDesc='" + projectDesc + '\'' + ", projectType='" + projectType + '\'' + ", projectId="
				+ projectId + '}';
	}
}
