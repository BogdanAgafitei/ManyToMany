package com.entitiess;

import org.hibernate.annotations.Subselect;
import org.hibernate.annotations.Synchronize;

import javax.persistence.*;

@Entity
@Subselect(value = "SELECT  d.id AS id, i.first_name AS firstName, d.hobby AS hobby " +
        "FROM instructor i " +
        "JOIN instructor_detail d " +
        "ON d.id = i.instructor_detail_id")
@Synchronize({"instructor", "instructor_detail_id"})
public class Result {

    @Id
    @Column(name = "id")
    private int id;


    @Column(name = "firstName")
    private String firstName;

    @Column(name = "hobby")
    private String hobby;

    public Result(){}
    public Result(String firstName, String title) {
        this.firstName = firstName;
        this.hobby = title;
    }



    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getTitle() {
        return hobby;
    }

    public void setTitle(String title) {
        this.hobby = title;
    }

    @Override
    public String toString() {
//       return "Result{"
//                "id= "+
//                ", firstName='" + firstName + '\'' +
//                ", hobby='" + hobby + '\'' +
//                '}';
        return String.format("Result{id=%s, firstName=%s, hobby=%s", id, firstName, hobby);
    }
}
