package com.portfolio.springbootweb.repository;

import com.portfolio.springbootweb.model.MyService;
import org.springframework.data.repository.CrudRepository;

public interface MyServiceRepository extends CrudRepository<MyService, String> {
}
