package com.sanjay.InventoryEnterpriseSystem.core;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@MappedSuperclass
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity<PK extends Serializable> extends AbstractPersistable<PK> {
    @CreatedDate
    @Column(name="created_at",nullable = false, updatable = false)
    @JsonFormat(pattern = "YYYY-MM-dd HH:mm:ss")
    private Date createdAt = new Date();

    @LastModifiedDate
    @Column(name="last_modified_at",nullable=false)
    @JsonFormat(pattern = "'YYYY-MM-dd HH:mm:ss")
    private Date lastModifiedAt = new Date();

    @Override
    public void setId(PK id){
        super.setId(id);
    }
}
