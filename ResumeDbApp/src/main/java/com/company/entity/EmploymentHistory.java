package com.company.entity;

import lombok.Data;

import java.util.Date;

@Data
public class EmploymentHistory {
    private Integer id;
    private String header;
    private Date beginDate;
    private Date endDate;
    private String jobDescription;
    private User user;

    public EmploymentHistory() {
    }

    public EmploymentHistory(Integer id, String header, Date beginDate, Date endDate, String jobDescription, User user) {
        this.id = id;
        this.header = header;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.jobDescription = jobDescription;
        this.user = user;
    }

    @Override
    public String toString() {
        return "EmploymentHistory{" +
                "id=" + id +
                ", header='" + header + '\'' +
                ", beginDate=" + beginDate +
                ", endDate=" + endDate +
                ", jobDescription='" + jobDescription + '\'' +
                ", user=" + user +
                '}';
    }
}
