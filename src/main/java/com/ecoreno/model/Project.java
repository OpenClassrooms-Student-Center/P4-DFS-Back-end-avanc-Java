package com.ecoreno.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class Project {

    private Long id;

    @NotBlank(message = "Le nom du projet est obligatoire")
    private String name;

    @NotBlank(message = "Le nom du client est obligatoire")
    private String owner;

    @Positive(message = "Le budget doit être positif")
    private double budget;

    private String description;
    private String impact = "Impact estimé à calculer";
    private ProjectStatus status = ProjectStatus.PLANNED;

    public Project() {
    }

    public Project(Long id, String name, String owner, double budget, String description, String impact, ProjectStatus status) {
        this.id = id;
        this.name = name;
        this.owner = owner;
        this.budget = budget;
        this.description = description;
        this.impact = impact;
        this.status = status;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getOwner() { return owner; }
    public void setOwner(String owner) { this.owner = owner; }
    public double getBudget() { return budget; }
    public void setBudget(double budget) { this.budget = budget; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getImpact() { return impact; }
    public void setImpact(String impact) { this.impact = impact; }
    public ProjectStatus getStatus() { return status; }
    public void setStatus(ProjectStatus status) { this.status = status; }
}
