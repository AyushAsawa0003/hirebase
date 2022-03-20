package com.application.hirebase.interviewer;

import javax.persistence.*;

@Entity
@Table(name = "interviewers")
public class Interviewer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "interviewer_id")
    private int interviewerID;

    @Column(name = "interviewer_name")
    private String interviewerName;

    @Column(name = "interviewer_email_id")
    private String interviewerEmailID;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "skills_id")
    private Skills skills;

//    @Column(name = "primary_skill")
//    private String primarySkill;
//
//    @Column(name = "secondary")
//    private String secondarySkill;
//
//    @Column(name = "tertiary_skill")
//    private String tertiarySkill;

    @Column(name = "no_of_interviews")
    private int noOfInterviews = 0;


    public Interviewer() {
    }

    public Interviewer(int interviewerID, String interviewerName, String interviewerEmailID, Skills skills, int noOfInterviews) {
        this.interviewerID = interviewerID;
        this.interviewerName = interviewerName;
        this.interviewerEmailID = interviewerEmailID;
        this.skills = skills;
        this.noOfInterviews = noOfInterviews;
    }

    public int getInterviewerID() {
        return interviewerID;
    }

    public void setInterviewerID(int interviewerID) {
        this.interviewerID = interviewerID;
    }

    public String getInterviewerEmailID() {
        return interviewerEmailID;
    }

    @Override
    public String toString() {
        return "Interviewer{" +
                "interviewerID=" + interviewerID +
                ", interviewerName='" + interviewerName + '\'' +
                ", interviewerEmailID='" + interviewerEmailID + '\'' +
                ", noOfInterviews=" + noOfInterviews +
                '}';
    }

    public void setInterviewerEmailID(String interviewerEmailID) {
        this.interviewerEmailID = interviewerEmailID;
    }

    public String getInterviewerName() {
        return interviewerName;
    }


    public void setInterviewerName(String interviewerName) {
        this.interviewerName = interviewerName;
    }

    public Skills getSkills() {
        return skills;
    }

    public void setSkills(Skills skills) {
        this.skills = skills;
    }

    public int getNoOfInterviews() {
        return noOfInterviews;
    }

    public void setNoOfInterviews(int noOfInterviews) {
        this.noOfInterviews = noOfInterviews;
    }
}
