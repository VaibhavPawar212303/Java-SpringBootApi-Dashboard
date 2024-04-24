package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entities.Build;

@Repository
public interface BuildRepository extends JpaRepository<Build, Long> {
    List<Build> findByProjectId(String projectId);
}


