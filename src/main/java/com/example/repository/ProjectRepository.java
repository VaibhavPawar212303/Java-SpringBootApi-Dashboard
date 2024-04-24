package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entities.Project;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    List<Project> findByUserId(Long userId);
}
