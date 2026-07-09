package com.ecoreno.service;

import com.ecoreno.exception.ResourceNotFoundException;
import com.ecoreno.model.Project;
import com.ecoreno.model.ProjectStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class ProjectService {

    private final List<Project> projects = new ArrayList<>();
    private final AtomicLong sequence = new AtomicLong(1);

    public ProjectService() {
        projects.add(new Project(sequence.getAndIncrement(), "Rénovation cuisine", "Claire", 8500, "Modernisation d’une cuisine éco-responsable", "Faible émission", ProjectStatus.IN_PROGRESS));
        projects.add(new Project(sequence.getAndIncrement(), "Isolation toiture", "Julien", 12000, "Amélioration thermique d’un logement", "Économie d’énergie", ProjectStatus.PLANNED));
    }

    public List<Project> findAll() {
        return projects;
    }

    public Project findById(Long id) {
        return projects.stream()
                .filter(project -> project.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("Projet introuvable avec l'id " + id));
    }

    public Project save(Project project) {
        Project saved = new Project(sequence.getAndIncrement(), project.getName(), project.getOwner(), project.getBudget(), project.getDescription(), project.getImpact(), project.getStatus());
        projects.add(saved);
        return saved;
    }

    public Project update(Long id, Project updatedProject) {
        Project existing = findById(id);
        existing.setName(updatedProject.getName());
        existing.setOwner(updatedProject.getOwner());
        existing.setBudget(updatedProject.getBudget());
        existing.setDescription(updatedProject.getDescription());
        existing.setImpact(updatedProject.getImpact());
        existing.setStatus(updatedProject.getStatus());
        return existing;
    }
}
