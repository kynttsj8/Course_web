package com.example.lab08.model;

import jakarta.persistence.*;
@Table(name = "course")
@Entity
public class Course {
    @Id
    private String id;
    private int course_level_id;
    private String name;
    private String name_vn;
    private int credit_theory;
    private int credit_lab;
    @Column(nullable = false)
    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCourse_level_id() {
        return course_level_id;
    }

    public void setCourse_level_id(int course_level_id) {
        this.course_level_id = course_level_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName_vn() {
        return name_vn;
    }

    public void setName_vn(String name_vn) {
        this.name_vn = name_vn;
    }

    public int getCredit_theory() {
        return credit_theory;
    }

    public void setCredit_theory(int credit_theory) {
        this.credit_theory = credit_theory;
    }

    public int getCredit_lab() {return credit_lab;}

    public void setCredit_lab(int credit_lab) {
        this.credit_lab = credit_lab;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
