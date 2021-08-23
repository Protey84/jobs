package com.protey.jobs.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Entity
public class Job extends AbstractBaseEntity{
    private Type type;
    private int quantity;
    @ManyToOne(fetch = FetchType.LAZY)
    private Task task;

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }



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
