package com.application.hirebase.interviewer;

import javax.persistence.*;

@Entity
@Table(name = "skills")
public class Skills {

    @Id
    @GeneratedValue
    @Column(name = "skill_id")
    private int skillID;

    @Column(name = "primary_skill")
    private String primarySkill;

    @Column(name = "secondary_skill")
    private String secondarySkill;

    @Column(name = "tertiary_skill")
    private String tertiarySkill;


    public Skills() {
    }

    public Skills(int skill_id, String primarySkill, String secondarySkill, String tertiarySkill) {
        this.skillID = skill_id;
        this.primarySkill = primarySkill;
        this.secondarySkill = secondarySkill;
        this.tertiarySkill = tertiarySkill;
    }

    public String getPrimarySkill() {
        return primarySkill;
    }

    public void setPrimarySkill(String primarySkill) {
        this.primarySkill = primarySkill;
    }

    public String getSecondarySkill() {
        return secondarySkill;
    }

    public void setSecondarySkill(String secondarySkill) {
        this.secondarySkill = secondarySkill;
    }

    public String getTertiarySkill() {
        return tertiarySkill;
    }

    public void setTertiarySkill(String tertiarySkill) {
        this.tertiarySkill = tertiarySkill;
    }

    public int getSkill_id() {
        return skillID;
    }

    public void setSkill_id(int skill_id) {
        this.skillID = skill_id;
    }
}

