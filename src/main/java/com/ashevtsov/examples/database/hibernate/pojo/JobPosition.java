package com.ashevtsov.examples.database.hibernate.pojo;

import javax.persistence.*;

/**
 * Created by Artem_Shevtsov on 6/6/2016.
 */
@Entity
@Table(name = "job_position")
public class JobPosition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Column(name = "job_position", nullable = false)
    private String jobName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }
}
