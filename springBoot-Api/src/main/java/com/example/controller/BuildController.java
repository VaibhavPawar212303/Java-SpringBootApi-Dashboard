package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.Build;
import com.example.entities.BuildData;
import com.example.service.BuildService;

@RestController
@RequestMapping("/builds")
public class BuildController {

	@Autowired
	private BuildService buildService;

	@GetMapping("/{projectId}")
	public ResponseEntity<List<Build>> getBuilds(@PathVariable("projectId") String projectId) {
		List<Build> builds = buildService.getBuildsByProjectId(projectId);
		return ResponseEntity.ok(builds);
	}

	@GetMapping("/build/{buildId}")
	public ResponseEntity<Build> getBuildById(@PathVariable("buildId") Long buildId) {
		Build build = buildService.getBuildById(buildId);
		return ResponseEntity.ok(build);
	}

	@PostMapping("/create")
	public ResponseEntity<String> createBuildByPassingData(@RequestBody BuildData buildData) {
		buildService.createBuild(buildData);
		return ResponseEntity.ok("Build Added Successfully");
	}
}
