package com.protey.jobs.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.ArrayList;

@Entity
public class Task extends AbstractBaseEntity{
    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    private ArrayList<Job> jobs;
    private LocalDate date;
    private String adress;
    private String phone;


// private User lastChangerUser;

    public Task(ArrayList<Job> jobs, LocalDate date, String adress, String phone) {
        this.jobs = jobs;
        this.date = date;
        this.adress = adress;
        this.phone = phone;
      //  this.lastChangerUser = lastChangerUser;
    }

    public Task() {

    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public ArrayList<Job> getJobs() {
        return jobs;
    }

    public void setJobs(ArrayList<Job> jobs) {
        this.jobs = jobs;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
