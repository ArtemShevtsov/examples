package com.ashevtsov.examples.database.hibernate.pojo;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Artem_Shevtsov on 6/6/2016.
 */
@Entity
@Table(name = "job_position")
public class JobPosition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_id", unique = true, nullable = false)
    private int jobId;

    @Column(name = "job_position", nullable = false)
    private String jobName;

    @ManyToMany(mappedBy = "jobPositions")
    private Set<Employee> employees;

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "JobPosition{" +
                "jobId=" + jobId +
                ", jobName='" + jobName + '\'' +
                '}';
    }
}
