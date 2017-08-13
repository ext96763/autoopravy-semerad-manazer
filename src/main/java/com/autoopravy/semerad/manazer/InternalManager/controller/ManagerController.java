package com.autoopravy.semerad.manazer.InternalManager.controller;

import com.autoopravy.semerad.manazer.InternalManager.mapper.ManagerRepository;
import com.autoopravy.semerad.manazer.InternalManager.model.User;
import com.wordnik.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping(value = "/manager")
public class ManagerController {

    @Autowired
    private ManagerRepository managerRepository;

    public ManagerController(ManagerRepository managerRepository){
        this.managerRepository = managerRepository;
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    @ApiResponse(code = 1,message = "get particular user", response = User.class)
    public List<User> getUser(){
        return managerRepository.getUser(2L);
    }


}