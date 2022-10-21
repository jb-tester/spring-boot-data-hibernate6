package com.mytests.spring.springbootdatahibernate6.data;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IssuesRepository extends CrudRepository<Issues, Long> {



    // enums:
    // https://youtrack.jetbrains.com/issue/IDEA-160992 - Show error when enum type passed as argument into native JPA query
    @Query(value = "select * from jbtests.issues where state = :state", nativeQuery = true)
    List<Issues> findByState(@Param("state") Issues.StateEnum state);

    @Query("SELECT o FROM Issues o WHERE o.priority = 'High' OR o.priority = com.mytests.spring.springbootdatahibernate6.data.PriorityEnum.Medium")
    List<Issues> findByPriority();

    // https://youtrack.jetbrains.com/issue/IDEA-244155
    @Query("SELECT o FROM Issues o WHERE o.priority IN ('High', 'Medium')")
    List<Issues> findByPriorities();

    @Query("SELECT o FROM Issues o WHERE o.priority = High")
    List<Issues> findByPrioritiesAsLiterals();

    // https://youtrack.jetbrains.com/issue/IDEA-80076
    @Query("SELECT o FROM Issues o WHERE o.priority IN (com.mytests.spring.springbootdatahibernate6.data.PriorityEnum.High, com.mytests.spring.springbootdatahibernate6.data.PriorityEnum.Medium)")
    List<Issues> findByPrioritiesAsTypes();

    // https://youtrack.jetbrains.com/issue/IDEA-232989
    @Query("select issue from Issues issue where issue.state=com.mytests.spring.springbootdatahibernate6.data.Issues$StateEnum.Open")
    List<Issues> findByStatesAsInnerClassTypes();


    // use static fields:
    @Query("select issue from Issues issue where issue.author = com.mytests.spring.springbootdatahibernate6.data.Issues.AUTHOR1")
    List<Issues> findByAuthors();


}
