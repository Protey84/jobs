package com.protey.jobs.entity;

import javax.persistence.Entity;

@Entity
public class Job extends AbstractBaseEntity{
    private Type type;
    private int quantity;

    public Job(Type type, int quantity) {
        this.type = type;
        this.quantity = quantity;
    }

    public Job() {

    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
