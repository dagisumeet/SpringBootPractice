package com.portfolio.springbootweb.Service;

import com.portfolio.springbootweb.exceptions.ServiceNotFoundException;
import com.portfolio.springbootweb.model.MySkill;
import com.portfolio.springbootweb.repository.MySkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class MySkillService {
    @Autowired
    MySkillRepository mySkillRepository;

    public List<MySkill>getAllSkill(){
        List<MySkill> allSkills = new ArrayList<>();
        mySkillRepository.findAll().forEach(allSkills::add);

        return allSkills;

    }


    public MySkill createSkill(MySkill mySkill) throws ServiceNotFoundException{

        return mySkillRepository.save(mySkill);
    }

    public Boolean updateSkill(String skillName, MySkill mySkill){

        var optionalSkill = mySkillRepository.findById(skillName);

        if(optionalSkill.isPresent()){
            var skill = optionalSkill.get();
            String skillConfidencePercentage = Objects.requireNonNull(mySkill.getConfidencePercentage(), skill.getConfidencePercentage());
            skill.setConfidencePercentage(skillConfidencePercentage);
            mySkillRepository.save(skill);
            return true;
        }else {
            throw new ServiceNotFoundException("The skill you are trying to update is not available.");
        }

    }

    public Boolean deleteSkill(String skillName){
        mySkillRepository.deleteById(skillName);
        return true;
            }

}
