package com.mytests.spring.springbootdatahibernate6.data;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Date;


/**
 * *
 * <p>Created by irina on 5/4/2022.</p>
 * <p>Project: sb3-web-freemarker</p>
 * *
 */
@Entity
@Table(name = "datesnumbers")
public class DatesAndNumbers {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "first_num")
    private Integer firstNum;
    @Basic
    @Column(name = "second_num")
    private Integer secondNum;
    @Basic
    @Column(name = "float_one")
    private Double floatOne;
    @Basic
    @Column(name = "float_two")
    private Double floatTwo;
    @Basic
    @Column(name = "first_date")
    private Date firstDate;
    @Basic
    @Column(name = "second_date")
    private Date secondDate;
    @Basic
    @Column(name = "time_one")
    private Date timeOne;
    @Basic
    @Column(name = "time_two")
    private Timestamp timeTwo;

    public DatesAndNumbers() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getFirstNum() {
        return firstNum;
    }

    public void setFirstNum(Integer firstNum) {
        this.firstNum = firstNum;
    }

    public Integer getSecondNum() {
        return secondNum;
    }

    public void setSecondNum(Integer secondNum) {
        this.secondNum = secondNum;
    }

    public Double getFloatOne() {
        return floatOne;
    }

    public void setFloatOne(Double floatOne) {
        this.floatOne = floatOne;
    }

    public Double getFloatTwo() {
        return floatTwo;
    }

    public void setFloatTwo(Double floatTwo) {
        this.floatTwo = floatTwo;
    }

    public Date getFirstDate() {
        return firstDate;
    }

    public void setFirstDate(Date firstDate) {
        this.firstDate = firstDate;
    }

    public Date getSecondDate() {
        return secondDate;
    }

    public void setSecondDate(Date secondDate) {
        this.secondDate = secondDate;
    }

    public Date getTimeOne() {
        return timeOne;
    }

    public void setTimeOne(Date timeOne) {
        this.timeOne = timeOne;
    }

    public Timestamp getTimeTwo() {
        return timeTwo;
    }

    public void setTimeTwo(Timestamp timeTwo) {
        this.timeTwo = timeTwo;
    }

    @Override
    public String toString() {
        return "DatesAndNumbers{" +
                "id=" + id +
                ", firstNum=" + firstNum +
                ", secondNum=" + secondNum +
                ", floatOne=" + floatOne +
                ", floatTwo=" + floatTwo +
                ", firstDate=" + firstDate +
                ", secondDate=" + secondDate +
                ", timeOne=" + timeOne +
                ", timeTwo=" + timeTwo +
                '}';
    }


}
