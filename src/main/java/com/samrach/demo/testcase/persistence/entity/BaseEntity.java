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
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @CreatedDate
    private LocalDateTime createdDate;

    @Setter
    @CreatedBy
    private String createdBy;

    @Setter
    @LastModifiedDate
    private LocalDateTime updatedDate;

    @Setter
    @LastModifiedBy
    private String updatedBy;

    @Setter
    @Column
    private LocalDateTime deletedAt;
}
