package com.webbfontaine.repoactivitiesanalyzer.core.data.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.ZoneId;

@MappedSuperclass
public abstract class AbstractDomainEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        AbstractDomainEntity that = (AbstractDomainEntity) o;

        return new EqualsBuilder()
                .append(id, that.id)
                .append(createdAt, that.createdAt)
                .append(updatedAt, that.updatedAt)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(createdAt)
                .append(updatedAt)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("createdAt", createdAt)
                .append("updatedAt", updatedAt)
                .toString();
    }

    public static Long getIdOrNull(final AbstractDomainEntity entity) {
        return entity != null ? entity.id : null;
    }

    @PrePersist
    public void setCreatedAtToNow() {
        LocalDateTime now = LocalDateTime.now(ZoneId.of("Z"));
        createdAt = now;
        updatedAt = now;
    }

    @PreUpdate
    public void setUpdatedAtToNow() {
        updatedAt = LocalDateTime.now(ZoneId.of("Z"));
    }
}
