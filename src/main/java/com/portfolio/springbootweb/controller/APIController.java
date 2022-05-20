package com.portfolio.springbootweb.controller;


import com.portfolio.springbootweb.Service.MyServiceService;
import com.portfolio.springbootweb.Service.MyEducationService;
import com.portfolio.springbootweb.Service.MySkillService;
import com.portfolio.springbootweb.model.MyEducation;
import com.portfolio.springbootweb.model.MyService;
import com.portfolio.springbootweb.model.MySkill;
import com.portfolio.springbootweb.model.PersonalInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;
import java.util.logging.Logger;

@RestController
public class APIController {

        @Autowired
        MyServiceService apiService;

        @Autowired
        MyEducationService myEducationService;

        @Autowired
        MySkillService mySkillService;




    @GetMapping(value = "/api/personal-info")
    public HashMap<String, Object> getPersonalInfo() {

        PersonalInfo personalInfo = new PersonalInfo();
        personalInfo.setName("Dagi Sumit");
        personalInfo.setEmail("dagi.sumit@gmail.com");
        personalInfo.setAge(38);
        personalInfo. setAddress("Tyler, Texas, USA");
        personalInfo.setCvURL("https://drive.google.com/file/d/1HqNvTW3xR9SAtmF9msTIoMLCpipXMHS3/view?usp=sharing");
        HashMap<String, Object> map = new HashMap<>();
        map.put("Sttus", "sucess");
        map.put("data", personalInfo);

        return map;
    }
    @GetMapping(value = "/api/service")
    public HashMap<String, Object> getMyServices() {

//        Collection<MyService> myServices = new HashSet<>();
//        myServices.add(new MyService("Java Developer", "I develop web applications based on Java.", ""));
//        myServices.add(new MyService("Java Trainer", "I give training in Java programming.", ""));
//        myServices.add(new MyService("I am a UI/UX Design", "I design UI/UX Design.", ""));
//        myServices.add(new MyService("App Design & Develop", "I design and develop app too.", ""));
//        myServices.add(new MyService("App Design & Develop", "I design and develop app too.", ""));
//        myServices.add(new MyService("App Design & Develop", "I design and develop app too.", ""));

       var myServices= apiService.getAllServices();


        HashMap<String, Object> map = new HashMap<>();
        map.put("Status", "success");
        map.put("data", myServices);

            return map;
    }

    @PostMapping(value = "/api/service")
    public HashMap<String, Object> addService(@Valid @RequestBody MyService myService) {

        Logger.getGlobal().info(myService.toString());

        var createdService= apiService.createService(myService);

        HashMap<String, Object> map = new HashMap<>();
        map.put("Status", "success");
        map.put("data", createdService);
        map.put("message", "The service is successfully created");
        return map;


    }

    @PutMapping(value = "/api/service/{serviceName}")
    public HashMap<String, Object> updateService(@PathVariable(name= "serviceName") String serviceName, @RequestBody MyService myService){

        Logger.getGlobal().info(myService.toString());
        Logger.getGlobal().info(serviceName);


        boolean isUpdated = apiService.updateService(serviceName,myService);

        HashMap<String, Object> map = new HashMap<>();

        if(isUpdated){
            map.put("Status", "success");
            map.put("data", myService);
            map.put("message", "The service is successfully updated");
        }else {
            map.put("Status", "failure");
            map.put("message", "Unable to update the service. Please check your service name");
        }

        return map;
    }


    @DeleteMapping(value = "api/service/{serviceName}")
    public HashMap<String, Object> deleteService(@PathVariable(name = "serviceName") String serviceName) {

        var isDeleted=apiService.deleteService(serviceName);

        HashMap<String, Object> map = new HashMap<>();

        if(isDeleted){
            map.put("Status", "success");
            map.put("message", "The service is successfully deleted");
        }else {
            map.put("Status", "failure");
            map.put("message", "Unable to delete the service. Please check your service name");
        }
        return map;
    }

    @GetMapping(value = "/api/resume")
    public HashMap<String, Object> getMyResume() {

//        ArrayList<MyEducation> myEducationList = new ArrayList<>();
//        myEducationList.add(new MyEducation("2000-2003", "Science of Computer", "Texas University", "I have been the class topper"));
//        myEducationList.add(new MyEducation("2004-2006", "Bachelor of Computer Science", "University of NewYork", "It was a great experience"));
//        myEducationList.add(new MyEducation("2007-2010", "Master of Computer Science", "Texas Boston", "Java was my major subject."));


       var myEducationList=  myEducationService.getAllEducations();

        HashMap<String, Object> map = new HashMap<>();
        map.put("Status", "success");
        map.put("data", myEducationList);

        return map;
    }

    @PostMapping(value = "/api/resume")
    public HashMap<String, Object> addEducation(@Valid @RequestBody MyEducation myEducation){

        Logger.getGlobal().info(myEducation.toString());

        var createdEducation =  myEducationService.createEducation(myEducation);

        HashMap<String, Object> map = new HashMap<>();
        map.put("Status", "success");
        map.put("Data", createdEducation);
        map.put("Message", "You have successfully posted this education data");

        return map;
    }
    @PutMapping(value = "/api/resume/{degree}")
    public HashMap<String , Object> updateEducation(@PathVariable(name="degree") String degree, @RequestBody MyEducation myEducation){

        Logger.getGlobal().info(myEducation.toString());
        Logger.getGlobal().info(degree);

        boolean isUpdated = myEducationService.updateEducation(degree,myEducation);

        HashMap<String, Object> map = new HashMap<>();
       if (isUpdated) {
           map.put("Status", "success");
           map.put("Data", isUpdated);
           map.put("Message", "You have successfully updated this education data");
       }else {
           map.put("Status", "failure");
           map.put("Message", "Unable to update the service. Please check the degree name.");
       }
        return map;
    }
    @DeleteMapping(value = "/resume/{degree}")
    public HashMap<String , Object> deleteEducation(@PathVariable (name = "degree") String degree) {

        var isDeleted = myEducationService.deleteEducation(degree);
        HashMap<String, Object> map = new HashMap<>();
        if (isDeleted) {
            map.put("Status", "success");
            map.put("Data", isDeleted);
            map.put("Message", "You have successfully deleted this education data");
        }else {
            map.put("Status", "failure");
            map.put("Message", "Unable to delete the service. Please check the degree name.");
        }
        return map;

    }


    @GetMapping(value = "/api/my-skill")
    public HashMap<String, Object> getMySkill() {

//        ArrayList<MySkill> mySkills = new ArrayList<>();
//        mySkills.add(new MySkill("Web Design", "80%"));
//        mySkills.add(new MySkill("React JS", "60%"));
//        mySkills.add(new MySkill("HTML & CSS", "80%"));
//        mySkills.add(new MySkill("Angular JS", "50%"));
//        mySkills.add(new MySkill("Java Script", "95%"));
//        mySkills.add(new MySkill("Boot Strap", "88%"));

        var mySkillList = mySkillService.getAllSkill();

        HashMap<String, Object> map = new HashMap<>();
        map.put("Status", "success");
        map.put("data", mySkillList);

        return map;
    }

    @PostMapping(value = "/api/my-skill")
    public HashMap<String, Object> addMySkill(@Valid @RequestBody MySkill mySkill) {

        Logger.getGlobal().info(mySkill.toString());

         var  createdSkill = mySkillService.createSkill(mySkill);
        HashMap<String, Object> map = new HashMap<>();
        map.put("Status", "success");
        map.put("Data", createdSkill);
        map.put("Message", "This skill has been created");

        return map;

    }
    @PutMapping(value = "/api/my-skill/{skillName}")
    public HashMap<String, Object> updateMySkill(@PathVariable(name= "skillName") String skillName, @RequestBody MySkill mySkill) {

        Logger.getGlobal().info(mySkill.toString());
        Logger.getGlobal().info(skillName);

        boolean isUpdated = mySkillService.updateSkill(skillName, mySkill);

        HashMap<String, Object> map = new HashMap<>();

//        map.put("Status", "success");
//        map.put("Message", "This skill has been updated");
//        return map;
//    }

        if (isUpdated) {
            map.put("Status", "success");
            map.put("data", isUpdated);
            map.put("Message", "This skill has been updated");
        } else {
            map.put("Status", "failure");
            map.put("Message", "Unable to update the skill. Please check your skill name.");
        }
        return map;
    }
        @DeleteMapping(value ="/api/my-skill/{skillName}")
    public HashMap<String, Object> deleteSkill(@PathVariable(name = "skillName") String skillName){

        var isDeleted = mySkillService.deleteSkill(skillName);

        HashMap<String, Object> map = new HashMap<>();

            if (isDeleted) {
                map.put("Status", "success");
                map.put("data", isDeleted);
                map.put("Message", "This skill has been deleted successfully.");
            } else {
                map.put("Status", "failure");
                map.put("Message", "Unable to delete the skill. Please check your skill name.");
            }
            return map;
        }


}
