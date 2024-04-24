package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.Build;
import com.example.entities.BuildData;
import com.example.repository.BuildRepository;

@Service
public class BuildService {

    @Autowired
    private BuildRepository buildRepository;

    public List<Build> getBuildsByProjectId(String projectId) {
        return buildRepository.findByProjectId(projectId);
    }

    public Build getBuildById(Long buildId) {
        return buildRepository.findById(buildId).orElse(null);
    }

    public void createBuild(BuildData buildData) {
        // Your implementation to parse BuildData and insert into database goes here
        Build build = new Build(); // Example: create a new Build object from BuildData
        buildRepository.save(build); // Example: save the build to the repository
    }
}
