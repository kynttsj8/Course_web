package com.example.lab08.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CourseDto {
    @NotEmpty(message = "The id is required")
    private String id;

    @NotEmpty(message = "The name is required")
    private String name;
    @NotNull(message = "The course level id is required")
    private int course_level_id;
    @NotEmpty(message = "The name_vn is required")
    private String name_vn;
    @NotNull(message = "The theory credit is required")
    private int credit_theory;
    @NotNull(message = "The lab credit is required")

    private int credit_lab;
    @NotEmpty
    @Size(min = 1, message = "The description should be at least 10 characters")
    @Size(max = 1000, message = "The description cannot exceed 1000 characters")
    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCourse_level_id() {
        return course_level_id;
    }

    public void setCourse_level_id(int course_level_id) {
        this.course_level_id = course_level_id;
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

    public int getCredit_lab() {
        return credit_lab;
    }

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
