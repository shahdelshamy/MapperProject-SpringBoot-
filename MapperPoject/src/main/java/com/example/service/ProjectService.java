package com.example.service;

import com.example.configuration.ProjectConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    private ProjectConfig projectConfig;

   public String getMessage(){
        return "Team Id:" +projectConfig.getId()+"\n"+"Team name:" +projectConfig.getName()+"\n"+"Team Members:" +projectConfig.getMembers();
   }
}
