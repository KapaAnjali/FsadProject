package com.ems.model;

import lombok.Data;
import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "performance_reviews")
public class PerformanceReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @Column(nullable = false)
    private LocalDate reviewDate;

    @Column(nullable = false)
    private String reviewer;

    @Column(nullable = false)
    private Integer rating; // 1-5

    @Column(nullable = false)
    private String strengths;

    @Column(nullable = false)
    private String areasForImprovement;

    @Column(nullable = false)
    private String goals;

    @Column(nullable = false)
    private String comments;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status = Status.PENDING;

    public enum Status {
        PENDING,
        COMPLETED,
        APPROVED
    }
} 