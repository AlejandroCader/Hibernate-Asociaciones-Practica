package org.HibernateApp.entity;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
@Entity
@Table(name = "marks")
public class Mark {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    private int mark;

    @ManyToOne
    @JoinColumn(name = "id_student")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "id_subject")
    private Subject subject;

    public Mark(Date date, int mark) {
        this();
        this.date = date;
        this.mark = mark;
    }

    public Mark() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Mark{" +
                "id=" + id +
                ", date=" + date +
                ", mark=" + mark +
                ", student=" + student +
                ", subject=" + subject +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mark mark1 = (Mark) o;
        return mark == mark1.mark && Objects.equals(id, mark1.id) && Objects.equals(date, mark1.date) && Objects.equals(student, mark1.student) && Objects.equals(subject, mark1.subject);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, mark, student, subject);
    }
}
