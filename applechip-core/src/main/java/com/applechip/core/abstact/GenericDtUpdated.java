package com.applechip.core.abstact;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@SuppressWarnings("serial")
@MappedSuperclass
public abstract class GenericDtUpdated<PK extends Serializable> extends GenericDtCreated<PK> {

  @Column(name = "updated_dt", insertable = true, updatable = true)
  protected Date updatedDt;

  @PreUpdate
  public void setUpdatedDt() {
    this.updatedDt = new Date();
  }

  @PrePersist
  public void setCreatedDt() {
    Date date = new Date();
    this.createdDt = date;
    this.updatedDt = date;
  }

  public Date getUpdatedDt() {
    return updatedDt;
  }

  public void setUpdatedDt(Date updatedDt) {
    this.updatedDt = updatedDt;
  }
}