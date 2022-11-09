package com.Himanshu.TTN.HibernateJpa3Rd.Entity;

import javax.persistence.Embeddable;

@Embeddable
public class Subject {
    private String subjectname;

    @Override
    public String toString() {
        return "Subject{" +
                "subjectname='" + subjectname + '\'' +
                '}';
    }

    Subject() {

    }

    public Subject (String subjectname) {
        this.subjectname = subjectname;
    }

    public String getSubjectname() {
        return subjectname;
    }
}
