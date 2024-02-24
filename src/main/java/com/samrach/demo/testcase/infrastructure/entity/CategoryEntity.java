package com.samrach.demo.testcase.infrastructure.entity;

import com.samrach.demo.testcase.constant.TableConstant;
import com.samrach.demo.testcase.infrastructure.request.category.CategoryRequest;
import com.samrach.demo.testcase.persistence.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;

@Entity
@Table(name = TableConstant.CATEGORY)
@Getter
@Setter
@NoArgsConstructor
public class CategoryEntity extends BaseEntity {
    @Column(unique = true)
    private String name;

    @Column
    private String description;

    public CategoryEntity(String name, String description) {
        super();
        this.name = name;
        this.description = description;
    }

    public CategoryEntity(Long id, String name, String description) {
        super.setId(id);
        this.name = name;
        this.description = description;
    }

    public CategoryEntity(CategoryEntity categoryEntity) {
        super();
        this.name = categoryEntity.getName();
        this.description = categoryEntity.getDescription();
    }

    public CategoryEntity(CategoryRequest request) {
        super();
        this.name = request.getName();
        this.description = request.getDescription();
    }


    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        CategoryEntity that = (CategoryEntity) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
