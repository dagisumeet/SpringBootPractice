package com.portfolio.springbootweb.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import java.util.Objects;

@AllArgsConstructor
@Entity(name ="my_education")
@NoArgsConstructor
@Table
public class MyEducation {
    @Getter
    @Setter
    @Id
    @Column(name ="my_degree")
    @NotEmpty(message = "Degree name should not be empty.")
    private String degree;
    @Getter
    @Setter
    @Column(name ="my_passYear", length = 10)
    @NotEmpty(message = "Education year should not be empty.")
    private String year;
    @Getter
    @Setter
    @Column(name ="my_university", length = 150)
    @NotEmpty(message = "University name should not be empty.")
    private String university;
    @Getter
    @Setter
    @Column(name ="my_education_Description", length = 200)
    @NotEmpty(message = "Education description should not be empty.")

    private String educationDescription;


    @Override
    public String toString() {
        return "MyEducation{" +
                "year='" + year + '\'' +
                ", degree='" + degree + '\'' +
                ", university='" + university + '\'' +
                ", educationDescription='" + educationDescription + '\'' +
                '}';
    }



}
