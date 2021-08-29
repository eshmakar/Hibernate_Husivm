package ru.eshmakar.entity;

import javax.persistence.*;

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
