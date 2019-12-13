package com.csi.vidaplus.rcm.claim.entity;

import com.csi.vidaplus.rulesengine.client.dto.RuleExecutionRequest;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Ahsan on 2/4/2018.
 */
@MappedSuperclass
public class BaseEntity {
    @Id
    //@GeneratedValue(strategy= GenerationType.AUTO)
    private String id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="created_date",updatable=false)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="modified_date")
    private Date modifiedDat;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifiedDat() {
        return modifiedDat;
    }

    public void setModifiedDat(Date modifiedDat) {
        this.modifiedDat = modifiedDat;
    }

    @PrePersist
    public final void preCreate() {
        createdDate = new Date();
    }

    @PreUpdate
    public final void preUpdate() {
        modifiedDat = new Date();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        BaseEntity other = (BaseEntity) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}
