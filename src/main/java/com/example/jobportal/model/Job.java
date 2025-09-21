package com.example.jobportal.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "jobs")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Changed from SEQUENCE to IDENTITY
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false, length = 200)
    private String title; // Changed from 'name' to 'title' for clarity

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "company_name", nullable = false)
    private String companyName;

    @Column(name = "location")
    private String location;

    @Column(name = "job_type")
    @Enumerated(EnumType.STRING)
    private JobType jobType; // FULL_TIME, PART_TIME, CONTRACT, INTERNSHIP

    @Column(name = "min_salary")
    private BigDecimal minSalary; // Changed from String to BigDecimal for better handling

    @Column(name = "max_salary")
    private BigDecimal maxSalary;

    @Column(name = "experience_required")
    private Integer experienceRequired; // Changed to Integer to allow null

    @ElementCollection
    @CollectionTable(name = "job_technologies", joinColumns = @JoinColumn(name = "job_id"))
    @Column(name = "technology")
    private List<String> technologies; // Changed from array to List

    @Column(name = "is_active")
    private Boolean isActive = true;

    @Column(name = "created_at", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "application_deadline")
    private LocalDateTime applicationDeadline;

    // Enum for job types
    public enum JobType {
        FULL_TIME("Full Time"),
        PART_TIME("Part Time"),
        CONTRACT("Contract"),
        INTERNSHIP("Internship"),
        REMOTE("Remote");

        private final String displayName;

        JobType(String displayName) {
            this.displayName = displayName;
        }

        public String getDisplayName() {
            return displayName;
        }
    }
}