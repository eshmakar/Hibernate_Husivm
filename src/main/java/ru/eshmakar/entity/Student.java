package ru.eshmakar.entity;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;


    /*optional = false - означает, что name не может быть null */
    /*fetch = FetchType.LAZY - чтобы подгрузить данные лениво, только по требованию*/
    @Basic(optional = false, fetch = FetchType.LAZY)

    /* name - какое имя использовать в БД, unique - уникальные или нет, length = длина строки,  scale и precision - грубость и точность при плавающих запятых*/
    @Column(unique = false)
    String name;

    /*чтобы записать значения enum как есть, используется эта аннотация*/
    @Enumerated(value = EnumType.STRING)
    private Days days;

    /*чтобы использовать дату, используется @Temporal (TIMESTAMP - дата+время, Date - только дата, Time - только время)*/
    @Temporal(value = TemporalType.DATE)
    private Date date;


    public Student(String name, Days days) {
        this.name = name;
        this.days = days;
    }

    public Student(String name, Days days, Date date) {
        this.name = name;
        this.days = days;
        this.date = date;
    }

    public Days getDays() {
        return days;
    }

    public void setDays(Days days) {
        this.days = days;
    }

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
