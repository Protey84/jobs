package com.protey.jobs.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.ArrayList;

@Entity
@Getter
@AllArgsConstructor
@Setter
public class Task extends AbstractBaseEntity{
    @OneToMany(mappedBy = "task", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    private ArrayList<Job> jobs;
    private String order;
    private LocalDate date;
    private String adress;
    private String phone;
    private boolean isActive;
    private Master master;


// private User lastChangerUser;

    public Task(String order, LocalDate date, String adress, String phone, Master master) {
        this.order=order;
        this.jobs = jobs;
        this.date = date;
        this.adress = adress;
        this.phone = phone;
        this.master=master;
      //  this.lastChangerUser = lastChangerUser;
    }

    public void addJob(Job job){
        jobs.add(job);
        job.setTask(this);
    }

    public void removeJob(Job job){
        jobs.remove(job);
        job.setTask(null);
    }

    public Task() {

    }

}
