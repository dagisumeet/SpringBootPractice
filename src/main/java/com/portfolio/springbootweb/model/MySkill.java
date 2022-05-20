package com.portfolio.springbootweb.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@AllArgsConstructor
@Entity(name = "my_skill")
@NoArgsConstructor
@Table
public class MySkill {

    @Getter
    @Setter
    @Id
    @Column(name= "my_skillName")
    @NotEmpty(message = "Skill name should not be empty.")
    private String skillName;

    @Getter
    @Setter
    @Column(name= "my_confidence")
    @NotEmpty(message = "Skill confidence percentage should not be empty.")
    @Size(min=2, max = 500, message = "Skill percentage should not be empty.")
    private String confidencePercentage;

    @Override
    public String toString() {
        return "MySkill{" +
                "skillName='" + skillName + '\'' +
                ", confidencePercentage='" + confidencePercentage + '\'' +
                '}';
    }
}
