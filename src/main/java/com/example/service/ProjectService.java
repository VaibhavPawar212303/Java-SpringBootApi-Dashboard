package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.dto.ProjectDTO;
import com.example.entities.Project;
import com.example.repository.ProjectRepository;

import java.util.List;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepository projectRepository;

	public Project createProject(ProjectDTO projectDTO) {
//        if (projectDTO.getProjectName() == null || projectDTO.getProjectName().isEmpty()) {
//            throw new IllegalArgumentException("Please Add Project Name");
//        } else if (projectDTO.getProjectDesc() == null || projectDTO.getProjectDesc().isEmpty()) {
//            throw new IllegalArgumentException("Please Add Project Description");
//        } else if (projectDTO.getProjectType() == null || projectDTO.getProjectType().isEmpty()) {
//            throw new IllegalArgumentException("Please Add Project Type");
//        }
		Project project = new Project();
		project.setUserId(projectDTO.getUserId());
		project.setProjectName(projectDTO.getProjectName());
		project.setProjectDesc(projectDTO.getProjectDesc());
		project.setProjectType(projectDTO.getProjectType());
		return projectRepository.save(project);

	}

	public List<Project> getProjectsByUserId(Long userId) {
		return projectRepository.findByUserId(userId);
	}

	public Project deleteProjectByUserId(Long userId) {
		Project projToDelete = projectRepository.findById(userId)
				.orElseThrow(() -> new IllegalArgumentException("Project does not exist"));
		projectRepository.deleteById(userId);
		return projToDelete;
	}

}
