package com.mytests.spring.springbootdatahibernate6.data;


import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "issues", schema = "jbtests")

public class Issues {
    public static final String PATTERN = "table";
    public static final String AUTHOR1 = "irina";
    public static final String AUTHOR2 = "ira";
    @Id
    @GeneratedValue
    private Long id;
    @Basic
    @Column(name = "title")
    private String title;
    @Basic
    @Column(name = "author")
    private String author;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "priority")
    @Enumerated(EnumType.STRING)
    private PriorityEnum priority;
    @Basic
    @Column(name = "state")
    @Enumerated(EnumType.STRING)
    private StateEnum state;


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public PriorityEnum getPriority() {
        return priority;
    }

    public void setPriority(PriorityEnum priority) {
        this.priority = priority;
    }


    public StateEnum getState() {
        return state;
    }

    public void setState(StateEnum state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Issues issues = (Issues) o;
        return Objects.equals(id, issues.id) && Objects.equals(title, issues.title) && Objects.equals(author, issues.author) && Objects.equals(description, issues.description) && priority == issues.priority && state == issues.state;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, author, description, priority, state);
    }

    @Override
    public String toString() {
        return "Issues{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", description='" + description + '\'' +
                ", priority=" + priority.name() +
                ", state=" + state.name() +
                '}';
    }

    public enum StateEnum {
        Open, Closed
    }
}
