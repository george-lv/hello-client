package com.greentown.learn.cloud;

import java.io.Serializable;
import java.util.Date;

import org.springframework.beans.BeanUtils;

public abstract class BaseRO implements Serializable {
    private static final long serialVersionUID = -7649569150898094006L;

    private Long              id;

    private Date              gmtCreate;

    private Date              gmtModify;

    public <T> T copyPropertiesTo(T target, String... ignoreProperties) {
        BeanUtils.copyProperties(this, target, ignoreProperties);
        return target;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModify() {
        return gmtModify;
    }

    public void setGmtModify(Date gmtModify) {
        this.gmtModify = gmtModify;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        BaseRO other = (BaseRO) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
