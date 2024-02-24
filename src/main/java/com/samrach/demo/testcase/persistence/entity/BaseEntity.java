package com.samrach.demo.testcase.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreatedDate
    private LocalDateTime createdDate;

    @CreatedBy
    private String createdBy;

    @LastModifiedDate
    private LocalDateTime updatedDate;

    @LastModifiedBy
    private String updatedBy;
    
    @Column
    private LocalDateTime deletedAt;

    // set createdDate and createdBy
    @PrePersist
    public void prePersist() {
        this.createdDate = LocalDateTime.now();
        this.createdBy = "system";
    }

    // set updatedDate and updatedBy
    @PreUpdate
    public void preUpdate() {
        this.updatedDate = LocalDateTime.now();
        this.updatedBy = "system";
    }

    // set deletedAt
    @PreRemove
    public void preRemove() {
        this.deletedAt = LocalDateTime.now();
        this.updatedBy = "system";
    }
}
