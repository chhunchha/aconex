package com.aconex.cost.contract.models;

import org.joda.time.DateTime;

import javax.persistence.*;

@Entity
@Table(name = "projects")
public class Project {

    private Long id;

    private String code;
    private String description;

    private DateTime createdAt;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public Project setId(Long id) {
        this.id = id;
        return this;
    }

    @Column(name = "created_at")
    public DateTime getCreatedAt() {
        return createdAt;
    }

    public Project setCreatedAt(DateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    @Column(name = "code")
    public String getCode() {
        return code;
    }

    public Project setCode(String code) {
        this.code = code;
        return this;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public Project setDescription(String description) {
        this.description = description;
        return this;
    }
}
