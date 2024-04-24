package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.dto.ProjectDTO;
import com.example.entities.Project;
import com.example.service.ProjectService;

@RestController
@RequestMapping
public class ProjectController {

	@Autowired
	private ProjectService projectService;

	@PostMapping("/create")
	public void createProject(@RequestBody ProjectDTO projectDTO) {
		//try {
		 projectService.createProject(projectDTO);
//			 ResponseEntity.ok("Build Added Successfully");
//		} catch (IllegalArgumentException e) { 
//			return ResponseEntity.badRequest().body(e.getMessage());
//		} catch (Exception e) {
//			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
//		}
	}

	@GetMapping("/user/{id}")
	public ResponseEntity<?> getProjectsByUserId(@PathVariable("id") Long userId) {
		try {
			return ResponseEntity.ok(projectService.getProjectsByUserId(userId));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
		}
	}
	
	@DeleteMapping("/user/{id}")
	public ResponseEntity<?> deleteProjectByUserId(@PathVariable("id") Long userId) {
		try {
			return ResponseEntity.ok(projectService.deleteProjectByUserId(userId));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
		}
		
	}
}
