package com.portfolio.springbootweb.Service;

import com.portfolio.springbootweb.exceptions.ServiceNotFoundException;
import com.portfolio.springbootweb.model.MyEducation;
import com.portfolio.springbootweb.repository.MyEducationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class MyEducationService {

    @Autowired
    MyEducationRepository myEducationRepository;

    public List<MyEducation> getAllEducations(){

        List<MyEducation> allEducation = new ArrayList<>();
        myEducationRepository.findAll().forEach(allEducation::add);

        return allEducation;

    }

    public MyEducation createEducation(MyEducation myEducation){

        return myEducationRepository.save(myEducation);

    }

    public Boolean updateEducation(String degree, MyEducation myEducation) throws ServiceNotFoundException{

        var optionalEducation = myEducationRepository.findById(degree);
        if (optionalEducation.isPresent()) {
            var education = optionalEducation.get();
            String educationDescription = Objects.requireNonNull(myEducation.getEducationDescription(), education.getEducationDescription());
            education.setEducationDescription(myEducation.getEducationDescription());
            String university = Objects.requireNonNull(myEducation.getUniversity(), education.getUniversity());
            education.setUniversity(myEducation.getUniversity());
            String year = Objects.requireNonNull(myEducation.getYear(), education.getYear());
            education.setYear(myEducation.getYear());

            myEducationRepository.save(education);

            return true;

        } else {
            throw new ServiceNotFoundException("The education you are trying to update is not available.");
        }
    }

    public boolean deleteEducation (String degree){
        myEducationRepository.deleteById(degree);
        return true;
    }
    }
