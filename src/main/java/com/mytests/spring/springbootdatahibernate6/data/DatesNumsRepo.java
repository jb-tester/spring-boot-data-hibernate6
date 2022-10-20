package com.mytests.spring.springbootdatahibernate6.data;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.sql.Time;
import java.util.Date;
import java.util.List;

/**
 * *
 * <p>Created by irina on 5/4/2022.</p>
 * <p>Project: sb3-web-freemarker</p>
 * *
 */
public interface DatesNumsRepo extends CrudRepository<DatesAndNumbers, Integer> {

    @Query("select d from DatesAndNumbers d where d.firstDate = local date ")
    List<DatesAndNumbers> query1();

    @Query("select d from DatesAndNumbers d where (local datetime - CAST(:time as localdatetime)) > d.timeOne and local time > d.timeTwo")
    List<DatesAndNumbers> query2(@Param("time") Time time);

    @Query("select d from DatesAndNumbers d where (extract(YEAR from :date) = YEAR(d.firstDate)) or (extract(MONTH from d.secondDate) = extract(MONTH from local date))")
    List<DatesAndNumbers> query3(@Param("date") Date date);

    @Query("select d from DatesAndNumbers d where ceiling(d.floatTwo) > 100 ")
    List<DatesAndNumbers> query4();

    @Query("select d from DatesAndNumbers d where exp(d.firstNum) > 100 ")
    List<DatesAndNumbers> query5();

    @Query("select d from DatesAndNumbers d where floor(d.floatTwo) > d.firstNum ")
    List<DatesAndNumbers> query6();

    @Query("select d from DatesAndNumbers d where ln(d.secondNum) < d.firstNum + 10")
    List<DatesAndNumbers> query7();

    @Query("select d from DatesAndNumbers d where power(d.firstNum+100, d.secondNum) > :num ")
    List<DatesAndNumbers> query8(@Param("num") int num);

    @Query("select d from DatesAndNumbers d where round(d.firstNum, d.secondNum) = :num ")
    List<DatesAndNumbers> query9(@Param("num") int num);

    @Query("select d from DatesAndNumbers d where sign(d.floatTwo) = -1 ")
    List<DatesAndNumbers> query10();

    @Query("select SUM(d.secondNum) from DatesAndNumbers d where coalesce(:foo, d.firstNum) > coalesce(d.floatTwo, d.floatOne)")
    Integer query11(@Param("foo") Integer foo);

    // @Query("select d from DatesAndNumbers d where d.firstNum > ?") // shows error, and this is ok!
    @Query("select d from DatesAndNumbers d where d.firstNum > ?1")
    List<DatesAndNumbers> query12(Integer param);

    @Query("select a from DatesAndNumbers a  where a.firstDate between a.secondDate and current_timestamp()")
    List<DatesAndNumbers> query13();

    @Query("select a from DatesAndNumbers a  where a.firstDate between a.secondDate and local_date()")
    List<DatesAndNumbers> query14();

    // https://youtrack.jetbrains.com/issue/IDEA-299266: new cast()
    @Query("select o from DatesAndNumbers o where CAST(o.firstDate as LocalDate) is not null ")
    List<DatesAndNumbers> testCastingToLocalDate();

    @Query("select o from DatesAndNumbers o where CAST(o.secondDate as LocalDateTime) is not null ")
    List<DatesAndNumbers> testCastingToLocalDateTime();

    @Query("select o from DatesAndNumbers o where CAST(o.firstNum as BigInteger) is not null ")
    List<DatesAndNumbers> testCastingToBigInteger();

    @Query("select o from DatesAndNumbers o where CAST(o.floatTwo as BigDecimal) is not null ")
    List<DatesAndNumbers> testCastingToBigDecimal();

    @Query("select d from DatesAndNumbers d where d.id > 0 " +
            "and (d.floatTwo > 0) " +
            "and ((d.floatTwo > 10) " +
            "or not (d.floatOne < 100) " +
            "or (?1 < cast(d.firstNum as integer)) " +
            "or (?2 = cast(d.firstDate as date))" +
            ")")
    List<DatesAndNumbers> logicalOperatorsExpr(int arg1, Date arg2);

    @Query("select o from DatesAndNumbers o where (day(o.firstDate) = ?#{[0]?.day}) or (month(?#{[1]}) = month(o.secondDate)) ")
    List<DatesAndNumbers> testSpEL1(Date myDate1, Date myDate2);

    @Query("select o from DatesAndNumbers o where cast(o.firstDate as localdate) >= ?#{T(java.time.LocalDate).now().minusMonths(40).withDayOfMonth(1)}")
    List<DatesAndNumbers> testSpEL2( );

    // TODO: !!! to check
    // https://youtrack.jetbrains.com/issue/IDEA-302781
    @Query("select count(d) filter(where d.firstNum  < 10 ) from DatesAndNumbers d")
    int useFilter();

    // TODO: !!! to check
    @Query("select nullif(d.firstNum, d.secondNum) from DatesAndNumbers d")
    List<DatesAndNumbers> useNullif();

    // TODO: !!! to check
    /*@Query("select d from DatesAndNumbers d where treat(d as DateAndNumbers).firstNum > 10")
    List<DatesAndNumbers> useTreat();*/

    @Query("select sysdate()")
     String test_date1( );

    @Query("select current_time()")
    String test_date2( );

    @Query("select day(current_date())")
    String test_date3( );

    @Query("select month( current_date())")
    String test_date4( );

    @Query("select year(current_timestamp())")
    String test_date5( );


    @Query("select d from DatesAndNumbers d where d.firstDate between d.secondDate and sysdate()")
    List<DatesAndNumbers> checkSysdate();

    @Query("select month(d.firstDate) from DatesAndNumbers d")
    List<String> functionInSelectClause();

}
