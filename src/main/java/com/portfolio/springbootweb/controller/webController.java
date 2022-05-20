package com.portfolio.springbootweb.controller;

import com.portfolio.springbootweb.Service.MyEducationService;
import com.portfolio.springbootweb.Service.MyServiceService;
import com.portfolio.springbootweb.Service.MySkillService;
import com.portfolio.springbootweb.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.*;
import java.util.logging.Logger;

@Controller
public class webController {


    @Autowired
    private MyServiceService service;

    @Autowired
    private MyEducationService education;

    @Autowired
    private MySkillService skill;


@GetMapping(value = "/")
    public String index(Model model){

    PersonalInfo personalInfo = new PersonalInfo();
    personalInfo.setName("Dagi Sumit");
    personalInfo.setEmail("dagi.sumit@gmail.com");
    personalInfo.setAge(38);
    personalInfo. setAddress("Tyler, Texas, USA");
    personalInfo.setCvURL("https://drive.google.com/file/d/1HqNvTW3xR9SAtmF9msTIoMLCpipXMHS3/view?usp=sharing");

    model.addAttribute("personalInfo",personalInfo);


//    Collection<MyService> myServices = new HashSet<>();
//    myServices.add(new MyService("Java Developer", "I develop web applications based on Java.", ""));
//    myServices.add(new MyService("Java Trainer", "I give training in Java programming.", ""));
//    myServices.add(new MyService("I am a UI/UX Design", "I design UI/UX Design.", ""));
//    myServices.add(new MyService("App Design & Develop", "I design and develop app too.", ""));
//    myServices.add(new MyService("App Design & Develop", "I design and develop app too.", ""));
//    myServices.add(new MyService("App Design & Develop", "I design and develop app too.", ""));


//    Collections.sort(myServices);
    var myServices = service.getAllServices();
    model.addAttribute("myServices",myServices);




//    ArrayList<MyEducation> myEducationList = new ArrayList<>();
//    myEducationList.add(new MyEducation("2000-2003", "Science of Computer", "Texas University", "I have been the class topper"));
//    myEducationList.add(new MyEducation("2004-2006", "Bachelor of Computer Science", "University of NewYork", "It was a great experience"));
//    myEducationList.add(new MyEducation("2007-2010", "Master of Computer Science", "Texas Boston", "Java was my major subject."));

    var myEducationList= education.getAllEducations();
    model.addAttribute("myEducations",myEducationList);



//    ArrayList<MySkill> mySkills = new ArrayList<>();

//    mySkills.add(new MySkill("Web Design", "80%"));
//    mySkills.add(new MySkill("React JS", "60%"));
//    mySkills.add(new MySkill("HTML & CSS", "80%"));
//    mySkills.add(new MySkill("Angular JS", "50%"));
//    mySkills.add(new MySkill("Java Script", "95%"));
//    mySkills.add(new MySkill("Boot Strap", "88%"));

    var mySkills = skill.getAllSkill();
    model.addAttribute("mySkills",mySkills);


    return "index";
    }













}
