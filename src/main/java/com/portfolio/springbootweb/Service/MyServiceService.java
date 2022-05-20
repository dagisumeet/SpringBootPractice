package com.portfolio.springbootweb.Service;


import com.portfolio.springbootweb.exceptions.ServiceNotFoundException;
import com.portfolio.springbootweb.model.MyService;
import com.portfolio.springbootweb.repository.MyServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class MyServiceService {

    @Autowired
    MyServiceRepository myServiceRepository;

    public List<MyService> getAllServices(){
        List<MyService> allServices = new ArrayList<>();
        myServiceRepository.findAll().forEach(allServices::add);

        return allServices;

    }

    public MyService createService(MyService myService) {

        return myServiceRepository.save(myService);

    }

    public Boolean updateService(String serviceName, MyService myService) throws ServiceNotFoundException{

        var optionalService = myServiceRepository.findById(serviceName);

        if(optionalService.isPresent()) {
            var service = optionalService.get();
            String serviceDescription = Objects.requireNonNullElse(myService.getServiceDescription(),service.getServiceDescription());
            service.setServiceDescription(myService.getServiceDescription());
            String serviceImage = Objects.requireNonNullElse(myService.getServiceImage(),service.getServiceImage());
            service.setServiceImage(myService.getServiceImage());

            myServiceRepository.save(service);

            return true;

        }else {
            throw new ServiceNotFoundException("The service you are trying to update is not available.");
        }
    }


    public boolean deleteService(String serviceName){
        myServiceRepository.deleteById(serviceName);
        return true;
    }


}
