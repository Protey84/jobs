package com.protey.jobs.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

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
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate date;
    private String adress;
    private String phone;
    private Master master;


// private User lastChangerUser;

    public Task(String order, LocalDate date, String adress, String phone, Master master) {
        this.order=order;
        this.date = date;
        this.adress = adress;
        this.phone = phone;
        this.master=master;
      //  this.lastChangerUser = lastChangerUser;
    }

    public Task() {
        this.order="0";
        this.date=LocalDate.now();
        this.adress="";
        this.master=Master.MASTER_3;
        this.phone="";
    }

}
