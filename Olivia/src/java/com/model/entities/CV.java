/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.entities;

import java.util.Objects;

/**
 *
 * @author gabri
 */
public class CV {
    private int Id;
    private String resume;
    private String experienceTravail;
    private String education;
    private String certification;
    private String competence;
    private String langue;

    public CV() {
    }

    public CV(String resume, String experienceTravail, String education, String certification, String competence, String langue) {
        this.resume = resume;
        this.experienceTravail = experienceTravail;
        this.education = education;
        this.certification = certification;
        this.competence = competence;
        this.langue = langue;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public void setExperienceTravail(String experienceTravail) {
        this.experienceTravail = experienceTravail;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public void setCertification(String certification) {
        this.certification = certification;
    }

    public void setCompetence(String competence) {
        this.competence = competence;
    }

    public void setLangue(String langue) {
        this.langue = langue;
    }

    public int getId() {
        return Id;
    }

    public String getResume() {
        return resume;
    }

    public String getExperienceTravail() {
        return experienceTravail;
    }

    public String getEducation() {
        return education;
    }

    public String getCertification() {
        return certification;
    }

    public String getCompetence() {
        return competence;
    }

    public String getLangue() {
        return langue;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.Id;
        hash = 53 * hash + Objects.hashCode(this.resume);
        hash = 53 * hash + Objects.hashCode(this.experienceTravail);
        hash = 53 * hash + Objects.hashCode(this.education);
        hash = 53 * hash + Objects.hashCode(this.certification);
        hash = 53 * hash + Objects.hashCode(this.competence);
        hash = 53 * hash + Objects.hashCode(this.langue);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CV other = (CV) obj;
        if (this.Id != other.Id) {
            return false;
        }
        if (!Objects.equals(this.resume, other.resume)) {
            return false;
        }
        if (!Objects.equals(this.experienceTravail, other.experienceTravail)) {
            return false;
        }
        if (!Objects.equals(this.education, other.education)) {
            return false;
        }
        if (!Objects.equals(this.certification, other.certification)) {
            return false;
        }
        if (!Objects.equals(this.competence, other.competence)) {
            return false;
        }
        if (!Objects.equals(this.langue, other.langue)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CV{" + "Id=" + Id + ", resume=" + resume + ", experienceTravail=" + experienceTravail + ", education=" + education + ", certification=" + certification + ", competence=" + competence + ", langue=" + langue + '}';
    }
    
}
